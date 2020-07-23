package Programs2019_20;

import java.util.*;
/**
 * Write a description of class OctBinary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class octBinary
{   String $0,$1,$2,$3,$4,$5,$6,$7,binary;int con,octal,n,digit;
    void database(){
        $0="000";$1="001";$2="010";$3="011";$4="100";$5="101";$6="110";$7="111";
    }

    void mainInitInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an Octal (Base 8) number, please");
        octal=sc.nextInt();
        binary="";con=0;n=octal;
    }

    void calcAndDisplay(){
        System.out.println(octal+" in binary is: ");
        while(n>0){digit=n%10;n/=10;
            if(digit==0){System.out.print($0);}
            else if(digit==1){System.out.print($1);}
            else if(digit==2){System.out.print($2);}
            else if(digit==3){System.out.print($3);}
            else if(digit==4){System.out.print($4);}
            else if(digit==5){System.out.print($5);}
            else if(digit==6){System.out.print($6);}
            else if(digit==7){System.out.print($7);}
        }
    }

    public static void main(){
        octBinary o=new octBinary();
        o.database();
        o.mainInitInput();
        o.calcAndDisplay();
    }
}
