import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.*;

public class PythonAccessMerriamWebster {
	public static String access() {	
		try {
			/* Uses ProcessBuilder to execute .bat file,
			Uses FileSystems and Path to find current directory
			Specifies current directory as working directory
			Waits for .bat file execution */
			String current_dir = FileSystems.getDefault().getPath(".").toAbsolutePath().normalize().toString();
			String current_env_dir = current_dir + "/Environment/Scripts/python.exe";
			ProcessBuilder pb = new ProcessBuilder(current_env_dir, "ScraperMerriam.py");
			File current_dir_file = new File(current_dir);
			pb.directory(current_dir_file);
			pb.redirectOutput(new File(current_dir + "/ScraperOutput.txt"));
			pb.redirectError(new File(current_dir + "/ScraperError.txt"));
			Process p = pb.start();
			try {
				p.waitFor();
			} catch(InterruptedException ex) {
				System.out.println("InterruptedException" + ex);
			}
		} catch(IOException ex) {
			System.out.println("IOException" + ex);
		}

		File output_path = new File(FileSystems.getDefault().getPath(".").toAbsolutePath().normalize().toString() + "/ScraperData.txt");
		String[] output = OutputReader.output_reader(output_path);
		String output_string = new String();
		for(int i = 0; i < output.length; i++) {
			output_string += output[i] + "\n";
		}
		return(output_string);
	}
}