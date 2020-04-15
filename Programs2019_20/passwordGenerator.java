package Programs2019_20;

import java.util.*;
/**
 * It's a password genarator that takes your first name, last mname and bday and outputs  acomputer generated password
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class passwordGenerator
{
    String fName,mName,lName, age, bday; char fName1st,fName2nd,ageFirst,ageLast,lName1st,lName2nd,mName1st,mName2nd;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your first name:");
        fName=sc.next();
        System.out.println("Please enter your middle name:");
        mName=sc.next();
        System.out.println("Please enter your last name:");
        lName=sc.next();
        System.out.println("Please enter your age:");
        age=sc.next();
        System.out.println("Enter your birthday. (DD/MM/YYYY)");               //haha yeah man
        bday=sc.nextLine();
        bday=sc.nextLine();
    }

    void calc(){
        fName1st=fName.charAt(0);
        fName2nd=fName.charAt(fName.length()-1);
        mName1st=mName.charAt(0);
        mName2nd=mName.charAt(mName.length()-1);
        lName1st=lName.charAt(0);
        lName2nd=lName.charAt(lName.length()-1);
        ageFirst=age.charAt(0);
        ageLast=age.charAt(age.length()-1);
    }

    void print(){
        System.out.println("\nThe password generated is:");
        int r=(int)(Math.random()*10);
        if(r<=5)
            System.out.println(""+lName1st+lName2nd+ageFirst+fName1st+fName2nd+ageLast+mName1st+mName2nd);
        else if(r>5)
            System.out.println("Boneless Chicken.");
    }

    public static void main(){
        System.out.println("Welcome to the password generator\n");
        passwordGenerator o=new passwordGenerator();
        o.init();
        o.calc();
        o.print();
    }
}
