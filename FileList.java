
import java.util.*;
import java.io.*;
/**
 * Write a description of class FileList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileList
{
    public static void main(String[] args) {
        final File folder = new File("C:\\Users\\Student.ICSELAB-21.000\\Desktop\\Rahil_XI\\Files");
        System.out.println("C:\\Users\\Student.ICSELAB-21.000\\Desktop\\Rahil_XI\\Files\n");
        ArrayList<File> result = search(folder);
        for (File f : result) {
            System.out.println(f.getName());
        }
    }

    public static ArrayList<File> search(File folder) {
        ArrayList<File> result = new ArrayList<File>();
        if (folder.listFiles() == null) {
            System.out.println("Empty folder");
        } else {
            for (File f : folder.listFiles()) {
                result.add(f);
            }
        }
        return result;
    }
}
