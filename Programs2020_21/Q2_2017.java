package Programs2020_21;
import java.io.*;
/**
 * Question 2 from 2017 ISC XII Grade Computer Sciecne Practical Question Paper.
 *
 * @author Rahil
 * @version 1.0.0
 */
public class Q2_2017
{
    int n;char[][] opt;char[] key;int[] score;int maxScore=0;
    Q2_2017(int N,char[][] OPT,char[] KEY){ //Constructor
        n=N;opt=OPT;key=KEY;
        score=new int[n];
        for(int i=0;i<=score.length-1;i++){
            score[i]=0;
        }
    }

    void calc(){
        for(int i=0;i<=opt.length-1;i++){
            for(int j=0;j<=opt[i].length-1;j++){
                if(opt[i][j]==key[j]){
                    score[i]++;
                }
            }
        }
        for(int k=0;k<=score.length-1;k++){
            if(score[k]>maxScore){maxScore=score[k];}
        }
    }

    void print(){
        System.out.println("SCORES:");
        for(int i=0;i<=opt.length-1;i++){
            System.out.print("Participant "+(i+1)+":");
            System.out.println("\t"+score[i]);
        }
        System.out.println("\nHighest Score");
        for(int j=0;j<=score.length-1;j++){
            if(score[j]==maxScore){
                System.out.println("Participant: "+(j+1));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int N;char[][] OPT;char[] KEY=new char[5];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of participants (has to be between 3 and 11)");
        N=Integer.parseInt(br.readLine());
        if(N<3||N>11){
            System.out.println("Error");
        }
        OPT=new char[N][5];
        System.out.println("Enter the participant's options:");
        for(int i=0;i<=OPT.length-1;i++){
            System.out.println("Participant: "+(i+1));
            for(int j=0;j<=OPT[i].length-1;j++){ 
                OPT[i][j]=(br.readLine().toUpperCase()).charAt(0);
            }
        }
        System.out.println("Enter Answer Key");
        for(int k=0;k<=KEY.length-1;k++){
            KEY[k]=((br.readLine()).toUpperCase()).charAt(0);
        }
        Q2_2017 o=new Q2_2017(N,OPT,KEY);
        o.calc();
        o.print();
    }
}
