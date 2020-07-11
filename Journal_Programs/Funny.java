package Journal_Programs;

import java.util.Scanner;

public class Funny {
    String input;
    Funny(String input){
        this.input=input;
    }
    void checkFunny(){
        String rev=reverse(input);
        input.toUpperCase();
        rev.toUpperCase();
        boolean isFunny=true;
        for(int i=0,j=1;j<=input.length()-1;i++,j++){
            if(Math.abs(((int)input.charAt(i)-(int)input.charAt(j)))!=Math.abs(((int)rev.charAt(i)-(int)rev.charAt(j)))){
                isFunny=false;
                System.out.println("This isn't funny.");
                break;
            }
        }
        if(isFunny){
            System.out.println("let r be the reverse of original string s");
            System.out.println("s  = "+ "\""+input+"\"");
            System.out.println("r  = "+ "\""+rev+"\"");
            for(int i=0,j=1;j<=input.length()-1;i++,j++){
                System.out.println("|"+input.charAt(i)+"-"+input.charAt(j)+"| = "+(input.charAt(i)-input.charAt(j))+" = |"+rev.charAt(i)+"-"+rev.charAt(j)+"|");
            }
        }
    }
    String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        Funny o = new Funny(input);
        o.checkFunny();
    }
}