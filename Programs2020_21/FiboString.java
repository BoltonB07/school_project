package Programs2020_21;

import java.util.Scanner;

public class FiboString {String X,Y,Z; int n;
    FiboString(){
        X="a";Y="b";Z="ba";
    }
    void accept(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of items");
        n=sc.nextInt();
    }
    void generate(){
        String temp;
        for(int i=1;i<=n;i++){
            if(i==1)
                System.out.print(X+", ");
            else if(i==2)
                System.out.print(Y+", ");
            else if(i==3)
                System.out.print(Z+", ");
            else {
                temp = Y;
                Y = Z;
                Z = Z.concat(temp);
                System.out.print(Z + ", ");
            }
        }
    }

    public static void main(String[] args) {
        FiboString o=new FiboString();
        o.accept();
        o.generate();
    }
}
/**
 * Var table:
 *  type    name    I/P/O   desc
 *  String  X       P       Stores a
 *  String
 */


