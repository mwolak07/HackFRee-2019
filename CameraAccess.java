import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.*;

public class CameraAccess {
	public static void access() {	
		try {
			/* Uses ProcessBuilder to execute .bat file,
			Uses FileSystems and Path to find current directory
			Specifies current directory as working directory
			Waits for .bat file execution */
			String current_dir = FileSystems.getDefault().getPath(".").toAbsolutePath().normalize().toString();
			String current_env_dir = current_dir + "/Environment/Scripts/python.exe";
			ProcessBuilder pb = new ProcessBuilder(current_env_dir, "Camera.py");
			File current_dir_file = new File(current_dir);
			pb.directory(current_dir_file);
			pb.redirectOutput(new File(current_dir + "/CameraOutput.txt"));
			pb.redirectError(new File(current_dir + "/CameraError.txt"));
			Process p = pb.start();
			try {
				p.waitFor();
			} catch(InterruptedException ex) {
				System.out.println("InterruptedException" + ex);
			}
		} catch(IOException ex) {
			System.out.println("IOException" + ex);
		}
	}
}