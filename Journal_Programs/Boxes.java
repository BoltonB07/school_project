package Journal_Programs;
/*
    1. Start
    2. Take the input n
    3. Divide n by 48, 24, 12, and 6
    4. Find n%48, n%24 and so on.
    5. End
 */

import java.util.Scanner;

public class Boxes {
    int n,n1;
    int totalBoxes=0;
    int box48=0;
    int box24=0;
    int box12=0;
    int box6=0;
    Boxes(int n){
        this.n=n;
        n1=this.n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Boxes o = new Boxes(n);
        o.calcBox();
        o.display();
    }
    void calcBox(){
        box48=n/48;
        n%=48;
        box24=n/24;
        n%=24;
        box12=n/12;
        n%=12;
        box6=n/6;
        n%=6;
    }
    void display(){
        if(box48!=0)
            System.out.println("48 * "+box48+" = "+(48*box48));
        if(box24!=0)
            System.out.println("24 * "+box24+" = "+(24*box24));
        if(box12!=0)
            System.out.println("12 * "+box12+" = "+(12*box12));
        if(box6!=0)
            System.out.println("6 * "+box6+" = "+(6*box6));
        System.out.println("Remaining Boxes: "+ n);
        System.out.println("Total number of Boxes: " + n1);
        System.out.println("Total number of cartons: " + totalBoxes);
    }
}
