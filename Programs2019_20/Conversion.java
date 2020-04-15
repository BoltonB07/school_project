package Programs2019_20;

import java.util.*;
/**
 * Write a description of class Conversion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conversion
{
    int n;
    void getInput(){
        Scanner sc=new Scanner(System.in);int sum=0;
        System.out.println("Enter a binary number to be converted to Decimal.");
        n=sc.nextInt();


        int na=n;String s="";
        s=s.valueOf(na);
        for(int i=0;i<=s.length()-1;i++){
            sum+=(int)(Math.pow(2,i)*(n%10));
        }


    System.out.println("The number is decimal is="+sum);
}

    public static void main(){
        Conversion o=new Conversion();
        o.getInput();
    }
}
