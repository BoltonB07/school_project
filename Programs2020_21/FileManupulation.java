package Programs2020_21;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class FileManupulation {
    String fileName;

    FileManupulation(String fileName) {
        this.fileName = fileName;
        File file  = new File(fileName);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        out.println("Enter file name:");
        String fileName = br.readLine().concat(".txt");
        FileManupulation o = new FileManupulation(fileName);
        int choice;
        do {
            out.println("1. Write\n2. Read\n3. Close");
            choice = Integer.parseInt(br.readLine());
            if (choice == 1) {
                o.write();
            } else if (choice == 2) {
                o.read();
            }
        } while (choice != 3);
        br.close();
    }

    void write() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        out.println("Enter text: ");
        String str = br.readLine();
        writer.write(str);
    }

    void read() throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
            out.println(sc.nextLine());
    }
}
