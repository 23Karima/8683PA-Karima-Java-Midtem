package data_structures;
import java.io.*;
public class DataReader {

    /**
     * INSTRUCTIONS
     * <p>
     * Create an API to read the .txt file and print it to the console.
     * HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     * <p>
     * Store and retrieve the file to/from a database table.
     * <p>
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     * <p>
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/
    public static void main(String[] args) {
        // This path is not correct;String textFilePath = System.getProperty("user.dir") + "/src/data_structures/data/self-driving-car.txt";
        // Get the current user directory
        String userDir = System.getProperty("user.dir");
        // Construct the correct file path by appending the file name to the user directory
        String filePath = userDir + File.separator + "/src/data_structures/data/" + "self-driving-car";
        // Create a File object representing the text file
        File txtFile = new File(filePath);

        try {
            // Create FileReader and BufferedReader to read the text file
            FileReader fr = new FileReader(txtFile);
            BufferedReader br = new BufferedReader(fr);

            String line;
            // Read each line from the text file and print it to the console
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader and FileReader
            br.close();
            fr.close();

        } catch (IOException ioe) {
            // Handle any exceptions that occur during file reading
            ioe.printStackTrace();
        }
    }
}

