package AttendanceEvaluation;
import java.util.*;
import java.io.*;
/**
 * DISCLAIMER: WORKS AS INTENDED
 * 
 * writeData() inputs date and absentee roll nos and writes the data in the file "absenteeList.txt" found in main package.
 * Path: D:\\BlueJ Stuff\\Rahil XI\\AbsenteeList.txt
 * 
 * readData()
 * 
 * How to read the file (for humans): Sample: 15 3 2020  1   5      2   5   16  23  30
 * The first 3 numbers is the date. The fourth is the serial Number, to be used by the software primarily.The fifth is the number of absentees (can be 0).
 * The remaining are the roll nos of the absentees (There can be no absentees too).
 *
 * @author BoltonB07
 * @version 1.0.9 15/3/2020
 * PS: I hate coronavirus.
 */
public class Data{
    void exe() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileWriter file = new FileWriter("absenteeList.txt",true);
        BufferedWriter bw=new BufferedWriter(file);
        String date="",absenteeList="";
        boolean continueLoop=true;
        int iterationCounter=0, serialNum=0;
        File f=new File("absenteeList.txt");
        if(f.length()==0){
            serialNum=0; System.out.println("File is currently empty");
        }
        else{
            Scanner line;
            FileReader fileLastLine=new FileReader(f);//No need to specify the pathname again
            BufferedReader lastLine=new BufferedReader(fileLastLine);
            String lastLineOfData=null, current = lastLine.readLine();
            while (current != null) { //Previously, the loop stopped when lastLineOfData is null
                lastLineOfData = current;
                current = lastLine.readLine();
                serialNum++;
            }
            line=new Scanner(lastLineOfData);
            System.out.println("The last entered date was: "+line.next()+" "+line.next()+" "+line.next());
        }
        while(continueLoop){
            if(iterationCounter>0){
                //Moved the below line here
                System.out.println('\u000C');  //Clears screen (The previous iteration)
                System.out.println("Number of entered days (IN THE CURRENT SESSION): "+iterationCounter);
                System.out.println("The last entered date was: "+date);

            }

            System.out.println("Lines of data already entered :"+serialNum);
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
            serialNum++;

            //Writing part of this program
            {

                StringTokenizer tk=new StringTokenizer(absenteeList,",");
                //writing to file
                bw.write(date+"\t"+serialNum+"\t"+tk.countTokens()+"\t");
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

    /*int[] readData(int serialNum){   
        
    }*/
}