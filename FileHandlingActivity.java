import java.io.*;

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

        // d. Read and display file contents

        // e. Create backup directory

        // f. Copy contents to backup file

        // g. List all files in both directories
    }

    public static void makeMainDirectory() {
        File dir = new File("mainDirectory");
        dir.mkdir();
    }

    public static void makeTextFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
    }

}
