import java.io.*;
import java.util.Scanner;

public class FileHandler {

    // Method to read a file
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to write to a file (overwrite content)
    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to append content to a file (modify file)
    public static void appendToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append(content);
            System.out.println("Content has been appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // File name to work with
        System.out.println("Enter the file name (with path if necessary):");
        String fileName = scanner.nextLine();

        // Read content from the file
        System.out.println("\nReading file content...");
        readFile(fileName);

        // Write new content to the file
        System.out.println("\nEnter the content to overwrite in the file:");
        String contentToWrite = scanner.nextLine();
        writeFile(fileName, contentToWrite);

        // Append new content to the file
        System.out.println("\nEnter the content to append to the file:");
        String contentToAppend = scanner.nextLine();
        appendToFile(fileName, contentToAppend);

        // Read the modified file content
        System.out.println("\nReading modified file content...");
        readFile(fileName);

        scanner.close();
    }
}
