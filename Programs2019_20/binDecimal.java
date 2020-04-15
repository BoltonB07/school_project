package Programs2019_20;

import java.util.*;
/**
 * Program takes a binary number as input and throws a decimal equivalent of it on the terminal window.
 *
 * @author Rahil Shaban
 * @version 1.0.1
 */
public class binDecimal
{
    int input,copInput,digits,sumDecimal,counter; int[] digitDecimal;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the binary number.");
        input=sc.nextInt();
        copInput=input;
        digits=0;
        sumDecimal=0;

    }

    void calc(){
        while(input>0){
            input/=10;
            digits++;
        }
        digitDecimal=new int[digits];
        input=copInput;
        counter=digitDecimal.length-1;
        while(input>0){

            digitDecimal[counter]=input%10;
            input/=10;
            counter--;
        }
        for(int i=0,j=digitDecimal.length-1;i<=digitDecimal.length-1;i++,j--){
            digitDecimal[j]=digitDecimal[j]*(int)(Math.pow(2,i));
        }
        for(int i=0;i<=digitDecimal.length-1;i++){
            sumDecimal+=digitDecimal[i];
        }
    }
    void disp(){
        System.out.println("The number in decimal is: "+sumDecimal);
    }

    public static void main(){
        binDecimal o=new binDecimal();
        o.init(); o.calc(); o.disp();
    }
}
