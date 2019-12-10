import java.util.*;
/**
 * Write a description of class freqSubstring here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class freqSubstring
{
    String s,sub;StringBuffer sb; int counter;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the text");
        s=sc.nextLine();
        System.out.println("Enter the substring");
        sub=sc.next();
        sb=new StringBuffer(s);
        counter=0;
    }
    void calc(){
        for(int i=0;i<=s.length()-sub.length();i++){
            if(sub.equals(sb.substring(i,i+sub.length()))){
                counter++;
            }
        }
    }
    void print(){
        System.out.println("The text you entered is: "+s+"\nThe substring you wanter to check the frequency of is: "+sub+"\nThe frequency of it is: "+counter);
    }
    public static void main(String[] args){
        freqSubstring ioExecuteSequence=new freqSubstring();
        ioExecuteSequence.init();
        ioExecuteSequence.calc();
        ioExecuteSequence.print();
    }
}
