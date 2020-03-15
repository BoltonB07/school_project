package AttendanceEvaluation;
import java.util.*;
import java.io.*;
/**
 * DISCLAIMER: WORKS AS INTENDED
 * 
 * This class inputs date and absentee roll nos and writes the data in the file "absenteeList.txt" found in main package.
 * Path: D:\\BlueJ Stuff\\Rahil XI\\AbsenteeList.txt
 *
 *How to read the file (for humans): Sample: 15 3 2020   5   2   5   16  23  30
 *The first 3 numbers is the date. The fourth is the number of absentees (can be 0). The remaining are the roll nos of the absentees (There can be no absentees too).
 *
 * @author BoltonB07
 * @version 1.0.0 15/3/2020
 */
public class StoreData
{
    void exe() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileWriter file = new FileWriter("absenteeList.txt",true);
        BufferedWriter bw=new BufferedWriter(file);
        String date="",absenteeList="";

        boolean continueLoop=true;
        int iterationCounter=0;
        while(continueLoop){
            System.out.println('\u000C');  //Clears screen (The previous iteration)
            //Input part of this program
            if(iterationCounter>0){   //QOL (Quality of Life)
                System.out.println("Number of entered days (in the current session): "+iterationCounter);
                System.out.println("Last entered date was: "+date);
            }
            System.out.println("Enter a date (<date in int> <month in int> <year in int>) Example = 17 3 2020");
            System.out.println("Enter \"exitprog\" anytime to terminate the program without entering the current cycle's data");
            date=br.readLine();
            if(date.equals("exitprog")){                //Termination Sequence
                continueLoop=false;
                break;
            }
            System.out.println("Enter absentees by separating with a <,>");
            absenteeList=br.readLine();
            if(absenteeList.equals("exitprog")){        //Termination Sequence
                continueLoop=false;
                break;
            }

            //Writing part of this program
            {
                StringTokenizer tk=new StringTokenizer(absenteeList,",");
                //writing to file
                bw.write(date);
                bw.write("\t"+tk.countTokens());
                while(tk.hasMoreTokens()){
                    bw.write("\t"+tk.nextToken());
                }
                bw.write("\n");
            }
            iterationCounter++;
        }
        bw.close();
        br.close();
    }
}
