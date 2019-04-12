import java.io.*;
import java.util.Arrays;

public class OutputReader {
    public static String[] output_reader(File file) {
        /* Get strings(lines) from std input and
	    puts them in a properly sized array */
        int i = 0;
        String s;
        String[] InputArray = new String[1000];

        // Tries to read user input using a buffered reader w/ an input stream reader
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            s = br.readLine();

            // Stores user input in an array
            while(s != null && i <= 1000)
            {
                InputArray[i] = s;
                s = br.readLine();
                i += 1;
            }

            br.close();
        }

        // Prints errors occuring during the input
        catch(Exception e)
        {
            System.out.println("Exception" + e);
        }

        // Creates a new array properly sized for the input
        String[] NewInputArray = Arrays.copyOfRange(InputArray, 0, i);
        return NewInputArray;
    }
}
