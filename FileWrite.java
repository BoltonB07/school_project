 

import java.io.*;
/**
 * Write a description of class FileWrite here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileWrite
{
    static void writeToBinaryFile(String name,String ext) throws IOException{
        FileOutputStream file=new FileOutputStream(name+ext,true);
        DataOutputStream dos=new DataOutputStream(file);
        BufferedReader bread=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter you must now what thee wants in thine file");
        String s=bread.readLine();
        dos.writeUTF(s);
    }
    static void writeToTextFile(String name,String ext) throws IOException{
        FileWriter file = new FileWriter(name+ext,true);
        BufferedWriter br=new BufferedWriter(file);
        System.out.println("Enter you must now what thee wants in thine file");
        BufferedReader bread=new BufferedReader(new InputStreamReader(System.in));
        br.write(bread.readLine());
        br.close();
        file.close();
    }
}
