package AttendanceEvaluation;
import java.io.*;
import java.util.*;

/**
 * Write a description of class ReadDataLine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReadData
{

    int[] line(int serialNum) throws IOException{   
        BufferedReader br=new BufferedReader(new FileReader("absenteeList.txt"));
        Scanner sc;
        String line;
        while((line=br.readLine())!=null){
            sc=new Scanner(line);
            sc.next();sc.next();sc.next();sc.next();sc.next();
            
        }
    }
}
