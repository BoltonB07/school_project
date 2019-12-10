import java.util.*;
/**
 * Write a description of class specialNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class specialNumber
{ int n,in,digits,temp,factemp,factsum,sumDigits,sumFact; int[] arr;boolean ifSpecial;
    void init(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter a number");
        in=sc.nextInt();
        n=in;
        factsum=1;
        ifSpecial=false;
        sumFact=0;
    }
    
    void calc(){
        while(n<0){
            n/=10;
            digits++;
        }
        n=in;
        arr=new int[digits];
        for(int i=0;i<=arr.length-1;i++){
            arr[i]=n%10;
            n/=10;
        }
        /*for(int i=0;i<)
         * for(int h=1;h<arr[i])
           */
        for(int i=1;i<=arr.length-1;i++){     //To find the factorial of each digit
            for(int j=1;j<=arr[i];j++){
                factsum=factsum*j;
                
            }
            sumFact+=factsum;
        }
        sumDigits=in;
        if(factsum==sumDigits){
            ifSpecial=true;
        }
        else if(factsum!=sumDigits){
            ifSpecial=false;
        }
    }
    void disp(){
        if(ifSpecial==true)
        System.out.println("The number is a Special Number");
        else if(ifSpecial==false)
        System.out.println("The number is not a Special Number");
    }
    public static void main(){specialNumber o=new specialNumber();
        o.init();
        o.calc();
        o.disp();
        
    }
}
