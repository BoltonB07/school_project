package Journal_Programs;

import java.util.Scanner;

import static java.lang.System.*;

public class FashionSentence {
    int a,b; String str;
    FashionSentence(int a, int b, String str){
        this.a=a;
        this.b=b;
        this.str=str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.println("Enter a sentence:");
        String str = sc.nextLine();
        out.println("Enter 2 numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        FashionSentence o=new FashionSentence(a,b,str);
        o.calc();
    }
    void calc(){
        Scanner sc = new Scanner(this.str);
        for(int i=0;sc.hasNext();i++){
            String str=sc.next();
            if(i==a-1||i==b-1){
                for(int j=0;j<=str.length()-1;j++)
                    out.print((char)(str.charAt(j)+1));
                out.print(" ");
            }
            else
                out.print(str+" ");
        }
    }
}
