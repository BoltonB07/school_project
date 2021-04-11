package Programs2020_21;

import java.util.Scanner;

public class Fascinating {
    int n,m;
    Fascinating(int n, int m){
        this.n=n;
        this.m=m;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        if(m<99||m>10000||n<99||n>10000) {
            System.out.println("Out of bounds");
            return;
        }
        Fascinating f= new Fascinating(n,m);
        f.calc();
    }
    void calc(){
        int counter=0;
        System.out.println("THE FASCINATING NUMBERS ARE: ");
        for(int i=m;i<=n;i++){
            if(isFascinating(i)){
                System.out.print(i+" ");
                counter++;
            }
        }
        System.out.println();
        if(counter==0)
            System.out.println("NIL");
        System.out.println("THE FREQUENCY OF FASCINATING NUMBERS IS: "+counter);
    }
    boolean isFascinating(int n){
        int numCount=0;
        String str,a,b,c;
        a=String.valueOf(n);
        b=String.valueOf(n*2);
        c=String.valueOf(n*3);
        str=(a.concat(b)).concat(c);
        for(int j=1;j<=9;j++) {
            for (int i = 0; i <= str.length() - 1; i++) {
                if (Character.getNumericValue(str.charAt(i)) == j)
                    numCount++;
            }
            if(numCount!=1)
                return false;
            numCount=0;
        }
        return true;
    }
}
