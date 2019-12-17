 

import java.io.*;
/**
 * Write a description of class FileMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileMain
{
    String fileName,ext;
    void mainFile() throws IOException{
        int input=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println('\u000C');
            System.out.println("---------------------------------");
            System.out.println("What does ye want?\n1)Create new file\n2)Wite to a file\n3)Read a file\n4)Exit File Explorer");
            System.out.println("---------------------------------");
            String in=br.readLine();
            input=Integer.valueOf(in);
            if(input==1){
                System.out.println('\u000C');
                System.out.println("What wilst thou name thine file?");
                fileName=br.readLine();
                System.out.println("What extension dost thou want?");
                ext=br.readLine();
                if(ext=="txt"){
                    FileCreate.makeTextFile(fileName,ext);
                }
                else{
                    FileCreate.makeBinaryFile(fileName,ext);

                }
                System.out.println("File '"+fileName+"' has been brought into existence with much success");
            }
            else if(input==2){
                System.out.println('\u000C');
                System.out.println("Name thine file");
                fileName=br.readLine();
                System.out.println("Name file's own extension");
                ext=br.readLine();
                String print;
                if(ext=="txt"){
                    FileWrite.writeToTextFile(fileName,ext);
                }
                else{
                    FileWrite.writeToBinaryFile(fileName,ext);
                }
            }
            else if(input==3){
                System.out.println('\u000C');
                System.out.println("Name thine file");
                fileName=br.readLine();
                System.out.println("Name file's own extension");
                ext=br.readLine();
                if(ext=="txt"){
                    System.out.println(FileRead.readTextFile(fileName,ext));
                }
                else{
                    System.out.println(FileRead.readBinaryFile(fileName,ext));
                }
            }
            else if(input!=1&&input!=2&&input!=3&&input!=4){
                System.out.println('\u000C');
                System.out.println("TRY AGAIN\n");
                mainFile();
            }
        }
        while(input!=4);
        br.close();
        System.exit(0);
    }

    public static void main(String[] foo) throws IOException{
        FileMain o=new FileMain();
        o.mainFile();
    }
}
