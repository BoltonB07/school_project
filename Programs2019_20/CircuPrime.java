package Programs2019_20;

import java.util.*;
class CircuPrime
{
    int[] number,number2;int n,swapper,num,numDigits,tempDigit;boolean ifCircularPrime;String s;
    void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        num=sc.nextInt();
        n=num; numDigits=0;
        while(n>0){
            n/=10;
            numDigits++;
        }
        number=new int[numDigits];number2=new int[numDigits];
        n=num;    //Restoring the original value to n.
        tempDigit=0;
        for(int i=0;i<numDigits;i++){        //Loop inserts the individual dogits in the array
            tempDigit=n%10;
            n/=10;
            number[i]=tempDigit;
        }
        swapper=0;
        s="";

    }

    void calc(){
        for(int i=0;i<numDigits;i++){                
            if(i==numDigits-1){number2[0]=number[i];}
            //else if()
           // {
          //      number2[i+1]=number[i];}
            for(int j=0;j<=numDigits-1;i++){
               // s=s.concat(valueOf(number2[i])) ;      //Rotated Number converted to String
            }

        }                                    
    }
}