import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingActivity {
    public static void main(String[] args) throws IOException {
        // Your code here

        // a. Create main directory
        makeMainDirectory();
        // b. Create three text files
        makeTextFile("notes.txt");
        makeTextFile("data.txt");
        makeTextFile("log.txt");
        // c. Write messages to files
        writeToFile("this is the beginning of my notes file.", "notes.txt");
        writeToFile("2, 4, 6, and 8 are even numbers.", "data.txt");
        writeToFile("Today I worked on 0.4 and 0.3.", "log.txt");
        // d. Read and display file contents
        System.out.println(getContents("data.txt"));
        // e. Create backup directory
        makeBackup();
        // f. Copy contents to backup file
        copyContents("notes.txt", "data.txt", "log.txt");
        // g. List all files in both directories
        listAllFiles("mainDirectory", "mainDirectory/Backup");

        // debug activity
        debugFileOperation();
    }

    public static void makeMainDirectory() {
        File dir = new File("mainDirectory");
        dir.mkdir();
    }

    public static void makeTextFile(String fileName) throws IOException {
        File file = new File("mainDirectory/" + fileName);
        file.createNewFile();
    }

    public static void writeToFile(String input, String fileName) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
        br.write(input);
        br.close();
    }

    public static String getContents(String fileName) throws IOException {
        File current = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(current));
        String output = "";
        while (br.ready()) {
            output += (char) br.read();
        }
        br.close();
        return output;
    }

    public static void makeBackup() {
        File dir = new File("mainDirectory/Backup");
        dir.mkdir();
    }

    public static void copyContents(String file1, String file2, String file3) throws IOException {
        File backup = new File("mainDirectory/Backup/backup.txt");
        BufferedWriter br = new BufferedWriter(new FileWriter(backup));
        br.write(getContents(file1));
        br.write(getContents(file2));
        br.write(getContents(file3));
        br.close();
    }

    public static void listAllFiles(String path1, String path2) {
        File directory1 = new File(path1);
        File directory2 = new File(path2);
        File[] dirOneFiles = directory1.listFiles();
        File[] dirTwoFiles = directory2.listFiles();
        System.out.println("Files in " + directory1.getName() + ":");
        for (File f : dirOneFiles) {
            if (f != null) {
                System.out.println(f.getName());
            }
        }
        System.out.println("Files in " + directory2.getName() + ":");
        for (File f : dirTwoFiles) {
            if (f != null) {
                System.out.println(f.getName());
            }
        }
    }

    public static void debugFileOperation() {
        try {
            // Creating a file with an invalid name (forward slash is invalid for file names
            // on many OS)
            File file = new File("fileName.txt");

            // Attempting to write to the invalid file
            FileWriter writer = new FileWriter(file);
            writer.write("Will this fail?");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
