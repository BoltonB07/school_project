package AttendanceEvaluation;

import java.util.*;
import java.io.*;
/**
 * Write a description of class testclass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testclass
{
    void main() throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("absenteeList.txt"));
        Scanner sc;
        String line;
        while((line=br.readLine())!=null){
            sc=new Scanner(line);
            System.out.println(sc.nextLine());
        }
    }

}
