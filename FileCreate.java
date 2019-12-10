import java.io.*;
/**
 * Write a description of class FileCreate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileCreate
{
    static void makeTextFile(String name, String ext) throws IOException{
        File file=new File(name+ext);
    }

    static void makeBinaryFile(String name,String ext) throws IOException{
        FileOutputStream file=new FileOutputStream(name+ext);
    }
}
