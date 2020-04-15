package Programs2019_20;

import java.util.*;
/**
 * Write a description of class BigSmolNum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BigNum
{
    Scanner sc=new Scanner(System.in);
        int dig=0,k=0;String out="";String in;
        char[] arr1;char[] arr;
        int big=0,fd=1;
    void init(){
        
        System.out.println("Enter a number");
        in = sc.next();
        char[]arr2=new char[in.length()];
        for(int i=0;i<in.length();i++){
            arr2[i]=in.charAt(i);
        }
        arr=arr2;
        arr1=arr2;
    big();}
        void big()
        {for(int kop=0;kop<in.length();kop++)
        {
            for(int x=0;x<in.length();x++){
                char lol=arr[x];
                 String o="";
                 o=o.valueOf(lol); 
                dig=Integer.parseInt(o);
                if(dig>big){
                    big=dig;
                    k=x;
                }
            }
          String JK="";
          JK=JK.valueOf(big);
          out=out+JK;big=0;
          arr[k]='0';fd++;
        }
        System.out.println(out);small();
    }
    void small()
    {int small=9;
    for(int kop=0;kop<in.length();kop++)
        {
            for(int x=0;x<in.length();x++){
                char lol=arr1[x];
                 String o="";
                 o=o.valueOf(lol); 
                dig=Integer.parseInt(o);
                System.out.println(dig);
                if(dig<small){
                    small=dig;
                    k=x;
                }
            }
          String JK="";
          JK=JK.valueOf(small);
          out=JK+out;small=9;
          arr1[k]='0';fd++;
        }
        System.out.println(out);}
}
