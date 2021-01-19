package Journal_Programs;

import java.util.Scanner;

public class RomanToDecimal {
    int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        RomanToDecimal o = new RomanToDecimal(n);
        o.convert();
    }
    RomanToDecimal(int n){
        this.n=n;
    }
    void convert(){
        while((n / 1000) != 0) {
            System.out.print("M");
            n-=1000;
        }
        while(n/500!=0) {
            System.out.print("D");
            n-=500;
        }
        while(n/100!=0) {
            System.out.print("C");
            n-=100;
        }
        while(n/50!=0) {
            System.out.print("L");
            n-=50;
        }
        while(n/10!=0) {
            System.out.print("X");
            n-=10;
        }
        while(n/5!=0) {
            System.out.print("V");
            n-=5;
        }
        while(n/1!=0) {
            System.out.print("I");
            n-=1;
        }
    }
}
