import java.io.*;
/**
 * Write a description of class FileRead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileRead
{
    static String readTextFile(String name,String ext) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader(name+ext);
        BufferedReader brea=new BufferedReader(fr);
        String bread;
        bread=brea.readLine();
        return bread;
    }
    static String readBinaryFile(String name,String ext) throws IOException{
        FileInputStream file=new FileInputStream(name+ext);
        DataInputStream din=new DataInputStream(file);
        String bread=din.readLine();
        return bread;
    }
}
