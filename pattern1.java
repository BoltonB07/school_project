 

import java.util.*;
/**
 * Write a description of class pattern1 here. NOT UPLOADED
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pattern1
{ 
    int i,n,j; static int lol; String s,trash; static boolean patternType;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows");
        n=sc.nextInt();
        System.out.println("Do you want an upside down pattern or straight pattern?");
        //trash=sc.next();
        s=sc.next();
        lol=333;
        if(s.contains("up")||s.contains("UP")||s.contains("uP")||s.contains("Up")){patternType=false;}
        else if(s.contains("st")||s.contains("ST")||s.contains("sT")||s.contains("St")){patternType=true;lol=333;}
        else if(s.contains("no")||s.contains("No")||s.contains("nO")||s.contains("NO")){patternType=false;lol=69;}
        else{
            lol=666;
        }
        i=0;j=0;
    }
    void print1(){   //Straight pattern
        for(i=0;i<=n;i++){
            for(j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    void print2(){
        for(i=1;i<=n;i++){
            for(j=1;j<=(n-(i-1));j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
   public static void main(){
       pattern1 o=new pattern1();
       o.init();
       if(patternType==true)
       o.print1();
       else if(patternType==false&&lol==333)
       o.print2();
       else if(patternType==false&&lol==69)
       System.out.println("K, bye!");
       else if(lol==666){
           System.out.println("Wrong input");
        }
    }
}
