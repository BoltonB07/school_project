package Journal_Programs;

import java.util.Scanner;

public class Goldbach {
    int n;
    Goldbach(int n){
        this.n=n;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        Goldbach o = new Goldbach(n);
        o.check();
    }
    boolean isOddPrime(int n){
        if(n==0||n==1||n%2==0)
            return false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    void check(){
        if(n%2!=0) {
            System.out.println("Invalid input, number is odd");
            return;
        }
        System.out.print("Prime pairs are: ");
        for(int i=2;i<=n/2;i++){
            if(isOddPrime(i)&&isOddPrime((n)-i))
                System.out.println(i+", "+((n)-i));
        }
    }
}
