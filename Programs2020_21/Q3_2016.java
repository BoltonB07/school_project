package Programs2020_21;

import java.util.*;
/**
 * Write a description of class Q3_2016 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Q3_2016
{
    String str,orstr; String[] arrstr;
    Q3_2016(String s){
        str=s;
        orstr=str;
        str.toUpperCase();
        Scanner sc=new Scanner(str);
        StringTokenizer tk=new StringTokenizer(str);
        arrstr=new String[tk.countTokens()];
        for(int i=0;i<=arrstr.length-1;i++){
            arrstr[i]=sc.next();
        }
    }
    void print(){int numVowel=0;
        for(int i=0;i<=arrstr.length-1;i++){
            if((arrstr[i].charAt(0)==65||arrstr[i].charAt(0)==69||arrstr[i].charAt(0)==73||arrstr[i].charAt(0)==79||arrstr[i].charAt(0)==85)&&(arrstr[i].charAt(arrstr[i].length()-1)==65||arrstr[i].charAt(arrstr[i].length()-1)==69||arrstr[i].charAt(arrstr[i].length()-1)==73||arrstr[i].charAt(arrstr[i].length()-1)==79||arrstr[i].charAt(arrstr[i].length()-1)==85)){
                numVowel++;
            }
        }
        System.out.println("Number of words beginning and ending with a vowel="+numVowel);
        for(int i=0;i<=arrstr.length-1;i++){
            if((arrstr[i].charAt(0)==65||arrstr[i].charAt(0)==69||arrstr[i].charAt(0)==73||arrstr[i].charAt(0)==79||arrstr[i].charAt(0)==85)&&(arrstr[i].charAt(arrstr[i].length()-1)==65||arrstr[i].charAt(arrstr[i].length()-1)==69||arrstr[i].charAt(arrstr[i].length()-1)==73||arrstr[i].charAt(arrstr[i].length()-1)==79||arrstr[i].charAt(arrstr[i].length()-1)==85)){
                System.out.println(arrstr[i]+" ");
                arrstr[i]="";
            }
        }
        for(int i=0;i<=arrstr.length-1;i++){
            System.out.println(arrstr[i]+" ");
        }
    }
    public static void main(){
        System.out.println("Enter sentence ending with a \".\" or \"?\" or \"!\"");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(!(s.charAt(s.length()-1)=='.' ||s.charAt(s.length()-1)=='?' ||s.charAt(s.length()-1)=='!')){
            System.out.println("INVALID INPUT");
            System.exit(0);
        }
        Q3_2016 o=new Q3_2016(s);
        o.print();
    }
}