import java.util.*;
/**
 * Takes 3 Strings as input and then compares the first character and then outputs the shtuff in order
 * 6 possible conditions:
 * abc,acb
 * bac,bca
 * cab,cba
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class compareWO
{
    String a,b,c;
    void init(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 3 Strings");
            a=sc.nextLine();
            b=sc.nextLine();
            c=sc.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Wrong input. Please start from the beginning again.");
            main();
        }
    }

    void calc(){
        if(a.charAt(0)<b.charAt(0)&&a.charAt(0)<c.charAt(0)){
            if(c.charAt(0)<b.charAt(0)){
                p2();
            }
            else{
                p1();
            }
        }
        else if(b.charAt(0)<a.charAt(0)&&b.charAt(0)<c.charAt(0)){
            if(c.charAt(0)<a.charAt(0)){
                p4();
            }
            else{
                p3();
            }
        }
        else if(c.charAt(0)<a.charAt(0)&&c.charAt(0)<b.charAt(0)){
            if(b.charAt(0)<a.charAt(0)){
                p6();
            }
            else{
                p5();
            }
        }
    }

    void p1(){
        System.out.println(a+" "+b+" "+c);
    }

    void p2(){
        System.out.println(a+" "+c+" "+b);
    }

    void p3(){
        System.out.println(b+" "+a+" "+c);
    }

    void p4(){
        System.out.println(b+" "+c+" "+a);
    }

    void p5(){
        System.out.println(c+" "+a+" "+b);
    }

    void p6(){
        System.out.println(c+" "+b+" "+a);
    }

    public static void main(){
        compareWO com=new compareWO();
        com.init();
        com.calc();
    }
}
