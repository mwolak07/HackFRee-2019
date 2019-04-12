import java.io.*;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.FileSystems;

public class Setup {
	public static void main(String[] args) {
		// Gets path to current directory
		String current_dir = FileSystems.getDefault().getPath(".").toAbsolutePath().normalize().toString();
		File current_dir_file = new File(current_dir);
		// Creates .bat files using a FileWriter
		try {
			// Creates environment install batch script
			BufferedWriter writer = new BufferedWriter(new FileWriter("SetupScript.bat"));
			String text = "pip install virtualenv\n"
						+ "cd " + current_dir + "\n"
						+ "virtualenv Environment\n"
						+ "cd " + current_dir + "/Environment/Scripts\n"
						+ "call activate\n"
						+ "pip install selenium\n"
						+ "pip install beautifulsoup4\n"
						+ "pip install google-cloud-vision\n"
						+ "pip install google-cloud-translate\n"
						+ "pip install opencv-python\n"
						+ "call deactivate\n"
						+ "cd " + current_dir + "\n"
						+ "javac OutputReader.java\n"
						+ "javac ImageFileReader.java\n"
						+ "javac PythonAccessMerriamWebster.java\n"
						+ "javac PythonAccessUrbanDictionary.java\n"
						+ "javac CameraAccess.java\n"
						+ "javac Interface.java\n"
						+ "javac ImageDisplay2.java\n"
						+ "javac ImageDisplay.java\n"
						+ "javac App.java";
			writer.write(text);
			writer.close();

			writer = new BufferedWriter(new FileWriter("App.bat"));
			text = "java App";
			writer.write(text);
			writer.close();

			writer = new BufferedWriter(new FileWriter("Settings.txt"));
			text = "English";
			writer.write(text);
			writer.close();

		} catch (IOException ex) {
			System.out.println("IOException" + ex);
		}

		/* Uses ProcessBuilder to execute .bat file,
			Uses FileSystems and Path to find current directory
			Specifies current directory as working directory
			Sets error and output files
			Waits for .bat file execution */
		try {
			ProcessBuilder pb = new ProcessBuilder("SetupScript.bat");
			File output = new File(current_dir + "/SetupOutput.txt");
			File error = new File(current_dir + "/SetupError.txt");
			pb.redirectOutput(output);
			pb.redirectError(error);
			pb.directory(current_dir_file);
			Process p = pb.start();
			try {
				p.waitFor();
				File setup_script = new File(current_dir + "/SetupScript.bat");
				setup_script.delete();
			} catch(InterruptedException ex) {
				System.out.println("InterruptedException" + ex);
			}
		} catch(IOException ex) {
			System.out.println("IOException" + ex);
		}
	}
}