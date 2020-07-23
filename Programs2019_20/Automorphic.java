package Programs2019_20;

import java.util.*;
/**
 * Write a description of class Automorphic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Automorphic
{
    int n,n1,digits,lastDigit,lastDigSquare;static boolean auto;String digitString;Integer n2;
    void input(){
        try{
            Scanner sc= new Scanner(System.in);
            System.out.println("Druk een nummer, alsjeblieft.");
            n=sc.nextInt();
            System.out.println("Checking...");

        }
        catch(InputMismatchException e){
            System.out.println("FOUT! Dat was geen nummer");
        }
        n1=n;
        lastDigit=0;
        auto=false;
        digits=0;
        digitString="";
        n2=new Integer(0);
    }

    void calc(){
        digitString=n2.toString();
        digits=digitString.length();
        lastDigit=n%(10*digits);
        n=n*n;
        lastDigSquare=n%(10*digits);
        if(lastDigit==lastDigSquare){
            auto=true;
        }
    }

    void dispTrue(){
        System.out.println("The number you entered was "+n1+"\nIT IS an Automorphic number.");

    }

    void dispFalse(){
        System.out.println("The number you entered was "+n1+"\nIt is NOT an Automorphic number.");
    }

    static void main(){
        Automorphic o=new Automorphic();
        o.input();
        o.calc();
        if(auto==true){
            o.dispTrue();
        }
        else{
            o.dispFalse();
        }

    }
}
