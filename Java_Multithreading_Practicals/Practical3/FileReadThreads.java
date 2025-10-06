import java.io.*;

class FileReaderThread extends Thread {
    private String fileName;
    public FileReaderThread(String fileName) { this.fileName = fileName; }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int lines = 0;
            while (br.readLine() != null) lines++;
            System.out.println(fileName + " -> Lines: " + lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class FileReadThreads {
    public static void main(String[] args) {
        String[] files = {"files/file1.txt", "files/file2.txt", "files/file3.txt"};

        for (String file : files) {
            new FileReaderThread(file).start();
        }
    }
}
