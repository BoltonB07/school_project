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
        String line="";  //contains the absentee List part
        String lineTemp;
        StringTokenizer tk;
        int[] arr;
        sc=new Scanner(br.readLine());
        sc.next();sc.next();sc.next();//sc.next();
        while(Integer.parseInt(sc.next())!=serialNum){
            sc=new Scanner(br.readLine());
            sc.next();sc.next();sc.next();//sc.next();
        }
        sc.next();sc.next();
        while(sc.hasNext()!=false){
            line.concat(" "+sc.next());
        }
        tk=new StringTokenizer(line," ");
        arr=new int[tk.countTokens()];
        for(int i=0;tk.hasMoreTokens();i++){
            arr[i]=Integer.parseInt(tk.nextToken());
        }
        return arr;
    }
}
