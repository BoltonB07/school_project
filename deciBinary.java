 

import java.util.*;
/**
 * "Remove the documentation, goddammit" ~Jasjyot 2019
 * "If this program gets famous, I'll get famous" ~Jasjyot 2019
 * "Stop quoting me" ~Jasjyot 2019
 * "There is no logic, that's the secret" ~Jasjyot 2019
 * (C) BoltonB07 2019
 *
 * @author BoltonB07 (Rahil Shaban)
 * @version 0.0.1 Alpha Release
 */
public class deciBinary
{  int n,b,a,c;int[] jas;
    void input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        n=sc.nextInt();
        System.out.println("Enter the base you want");
        b=sc.nextInt();
        c=0;
        a=n;
    }

    void calc(){
        for(int i=0;a!=0;i++){
            a=a/b;
            c++;
        }
        jas = new int[c];
        for( int j=0;n!=0;j++){
            jas[j]=n%b;
            n=n/b;
        }
    }

    void disp(){
        System.out.print("The output in base "+b+" is:\n");
        for(int i=jas.length-1;i>=0;i--){
            System.out.print(jas[i]);
        }
    }

    public static void main(){
        deciBinary o=new deciBinary();
        o.input();
        
        o.calc();
        o.disp();
    }
}
