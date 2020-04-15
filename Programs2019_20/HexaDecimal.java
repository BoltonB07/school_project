package Programs2019_20;

import java.util.*;
/**
 * Program takes a hexadecimal number as input and throws a decimal equivalent of it on the terminal window.
 *
 * @author Rahil Shaban
 * @version 1.0.0
 */
public class HexaDecimal
{
    String input,copInput;int digits,sumDecimal,counter;String[] Hexa; int[] digitDecimal;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the hexadecimal number.");
        input=sc.next();
        copInput=input;
        digits=0;
        sumDecimal=0;

    }

    void calc(){
        digits=input.length();
        Hexa=new String[digits];
        digitDecimal=new int[digits];
        input=copInput;
        counter=digitDecimal.length-1;
        for(int i=0;i<=input.length()-1;i++){
            Hexa[i]=Character.toString(input.charAt(i));
        }
        for(int i=0;i<=Hexa.length-1;i++){

            if(Hexa[i].equalsIgnoreCase("A"))
                digitDecimal[i]=10;
            else if(Hexa[i].equalsIgnoreCase("B"))
                digitDecimal[i]=11;
            else if(Hexa[i].equalsIgnoreCase("C"))
                digitDecimal[i]=12;
            else if(Hexa[i].equalsIgnoreCase("D"))
                digitDecimal[i]=13;
            else if(Hexa[i].equalsIgnoreCase("E"))
                digitDecimal[i]=14;
            else if(Hexa[i].equalsIgnoreCase("F"))
                digitDecimal[i]=15;
            else
                digitDecimal[i]=Integer.parseInt(Hexa[i]);       //1-11-23
        }
        int power=digitDecimal.length-1;
        for(int i=0;i<=digitDecimal.length-1;i++,power--){
            digitDecimal[i]=digitDecimal[i]*(int)(Math.pow(16,power)); //Multiplies the value by (16 to the power of the weight of the digit.
        }
        for(int i=0;i<=digitDecimal.length-1;i++){
            sumDecimal+=digitDecimal[i];
        }

    }

    void disp(){
        System.out.println("The number in decimal is: "+sumDecimal);
    }

    public static void main(){
        HexaDecimal o=new HexaDecimal();
        o.init(); o.calc(); o.disp();
    }
}
