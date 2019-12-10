import java.util.*;

public class ShiftCryptTM
{
    String s,tempString; int EF,letef; char letter; StringBuffer sb;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your text to be encrypted.");
        s=sc.nextLine();
        System.out.println("Please enter the Encryption Factor");
        EF=sc.nextInt();
        sb=new StringBuffer(s);
    }

    void calc(){
        int temp;
        //Turning everything to int.
        int let=0;
        for(int i=0;i<=s.length()-1;i++){
            letter=s.charAt(i);
            let=letter;
            if(let==32) {
                continue;
            }
            else if(letter<=90&&letter>=65){
                temp=90;
                if(let+EF>90){
                    letef=let+EF;
                    letef/=90;
                    let=(((let+EF)-(letef*90)+65))-1;
                    letter=(char)let;
                    tempString=tempString.valueOf(letter);
                    sb.replace(i,i+1,tempString);
                }
                else{
                    let+=EF-1;
                    letter=(char)let;
                    tempString=tempString.valueOf(letter);
                    sb.replace(i,i+1,tempString);
                }
            }
            else if(letter<=122&&letter>=97){
                temp=122;
                if(let+EF>57){
                    letef=let+EF;
                    let=(((let+EF)-(letef*122)+97))-1;
                    letter=(char)let;
                    tempString=tempString.valueOf(letter);
                    sb.replace(i,i+1,tempString);
                }
                else{
                    let+=EF-1;
                    letter=(char)let;
                    tempString=tempString.valueOf(letter);
                    sb.replace(i,i+1,tempString);
                }
            }
            else{
                System.out.println("ERROR #6003\nTERMINATING PROGRAM");
                return;
            }
        }
    }

    void print(){
        System.out.println("The cipher:\n"+sb);
    }

    public static void main(){
        ShiftCryptTM o=new ShiftCryptTM();
        o.init();
        o.calc();
        o.print();
    }
}