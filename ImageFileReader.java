import javax.swing.JFileChooser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageFileReader {

    //Declare Variable
    public static void main(String[] args){
        try {
            PickMe();
        } catch (Exception ex) {
            System.out.println("ok");
        }
    }

    static JFileChooser fileChooser = new JFileChooser();

    public static String PickMe() throws Exception {
        BufferedImage image = null;

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            //get the file
            java.io.File file = fileChooser.getSelectedFile();
            File temp = file;
            String text = file.toString();
            image = ImageIO.read(temp);
             try{
                // temp = new File(FileSystems.getDefault().getPath(".").toAbsolutePath().normalize().toString() + "/image.jpg");
                 temp = new File("C:\\Users\\mwola\\Desktop\\Projects\\image.jpg");
                 ImageIO.write(image, "jpg", temp);
                 text = temp.toString();
             } catch(IOException e){
                 System.out.println("Error: " + e);
             }

            return text;

        }
        return null;
    }
}