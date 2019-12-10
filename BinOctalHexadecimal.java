import java.util.*;
/**
 * Write a description of class BinOctalHexadecimal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinOctalHexadecimal
{
    boolean isOctal;String base,binaryInput,copyInput,zeroOctal1,zeroOctal2,zeroHexa1,zeroHexa2,zeroHexa3;int inputLength,divider;
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void initialization()
    {
        System.out.println("Please enter a binary number (with no decimals)");
        Scanner sc=new Scanner(System.in);
        binaryInput=sc.next();
        System.out.println("What do you want to convert it to?");
        base=sc.nextLine();
        if(base.contains("octa")){
            isOctal=true;
        }
        else{isOctal=false;}
        inputLength=binaryInput.length();
        zeroOctal1="0";zeroOctal2="00";
        zeroHexa1="0";zeroHexa2="00";zeroHexa3="000";
        copyInput=binaryInput;
        Integer arr[]= new Integer[(inputLength/3)+1];
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void ifOctal()                              //cancel all the if else statements and make it a loop where it divides by 3 and checks remainder and adds zeroes as necessary
    {
        for(int i= inputLength-1;i<i-3;i--){
            char v= copyInput.charAt(i);
            String j="";
            j=v+j;
            
        }
    }

}
