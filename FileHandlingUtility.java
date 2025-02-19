import java.io.*;
import java.nio.file.*;

public class FileHandlingUtility {
    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        createAndWriteFile();
        readFile();
        modifyFile();
        readFile(); // Read again to verify modifications
    }

    // Method to create and write to a file
    public static void createAndWriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Hello, this is a sample text file.\n");
            writer.write("It demonstrates file handling in Java.\n");
            System.out.println("File created and data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read the file
    public static void readFile() {
        System.out.println("\nReading File Contents:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify the file by appending text
    public static void modifyFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("This line is newly added to modify the file.\n");
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
