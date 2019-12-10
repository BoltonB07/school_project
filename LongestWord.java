import java.util.*;
/**
 * Write a description of class Longest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LongestWord
{
    String[] arr;String s,longest,shortest;boolean isEnding,loopcond; int words=0;
    void init(){
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        loopcond=true;
         Scanner sc1=new Scanner(s);
        while(loopcond){
            if(sc1.hasNext()){
                words++;
                sc1.next();
            }
            else{
                loopcond=false;
            }
        }
        Scanner sc2=new Scanner(s);
        arr = new String[words];
        for(int i=0;i<=words-1;i++){
            arr[i]=sc2.next();
        }
    }
    void calc(){
        int indexLongest=0,longDigit=0,indexShortest=0,shortDigit=0;
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i].length()>longDigit){
                indexLongest=i;
                longest=arr[i];
            }
        }
        for(int j=0;j<=arr.length-1;j++){
            if(arr[j].length()>shortDigit){
                indexShortest=j;
                shortest=arr[j];
            }
        }
        if(longest.endsWith(shortest)){
            isEnding=true;
        }
    }
    void print(){
        if(isEnding)
        System.out.println("The longest word ends with the shortest word");
        else
        System.out.println("The longest word does not end with the shortest word");
    }
    public static void main(){
        LongestWord o=new LongestWord();
        o.init();
        o.calc();
        o.print();
    }
}