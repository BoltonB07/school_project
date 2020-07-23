package AttendanceEvaluation;
//import org.jetbrains.annotations.NotNull;

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
    static int[] line(int serialNum) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("absenteeList.txt"));
        for(int i=1;i<=serialNum-1;i++){
            br.readLine();
        }
        Scanner sc= new Scanner(br.readLine());
        sc.next();sc.next();sc.next();sc.next();sc.next();
        //Contains the absentee List part
        String line = "";
        while(sc.hasNext()) line.concat(" " + sc.next());
        StringTokenizer tk = new StringTokenizer(line);
        int[] arr = new int[tk.countTokens()];
        for(int i=0;tk.hasMoreTokens();i++){
            arr[i]=Integer.parseInt(tk.nextToken());
        }
        sc.close();
        br.close();
        return arr;
    }
}
