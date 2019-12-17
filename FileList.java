 

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
        final File folder = new File("C:\\Users\\Student\\Desktop\\Rahil_XI\\Files");
        System.out.println("C:\\Users\\Student\\Desktop\\Rahil_XI\\Files\n");
        List<String> result = new ArrayList<>();
        search(".*\\.*", folder, result);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {
            result.add(f.getParentFile().getName());
        }
    }
}
