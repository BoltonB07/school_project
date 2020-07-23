package Programs2019_20;

import java.io.*;
/**
 * Write a description of class Prime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Prime
{
    int[] arr;int lim,counter;boolean isPrime;float divide;
    void init() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        arr=new int[10];
        for(int i=0;i<=9;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        divide=0;
        counter=0;
        isPrime=false;
    }

    void calc(){
        for(int j=0;j<=9;j++){
            lim=arr[j]/2;
            for(int i=2;i<=lim;i++){
                divide=arr[j]/i;
                if(divide-(Math.floor(arr[j]/i))==0){
                    counter++;
                }
            }
            if(counter==0){isPrime=true;}
            if(isPrime){print(j);}
            counter=0;    //resetting the counter value.
        }
    }

    void print(int a){
        System.out.print(arr[a]+", ");
    }

    public static void main(String[] foo) throws IOException{
        Prime o=new Prime();
        o.init();
        o.calc();
    }
}
