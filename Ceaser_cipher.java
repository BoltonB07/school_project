 

import java.util.Scanner;
public class Ceaser_cipher
{
    int shift;String str;String temp;
    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        str=sc.nextLine();
        str=str.toUpperCase();
        System.out.println("Enter shift");
        shift=sc.nextInt(); temp=str;
    }
    void Calculate()
    {
        int ascii;char out=' ';String output="";
        for(int i=0;i<=str.length()-1;i++)
        {
            ascii=str.charAt(i);int sum=ascii+shift;
            if(sum>90)
            {
                ascii=sum-26;out=(char)ascii;output+=out;
            }
            if(sum<65)
            {
                ascii=sum+26;out=(char)ascii;output+=out;
            }
            else
            {
                ascii=ascii+shift;out=(char)ascii;output+=out;
            }
        }
        for(int i=0;i<=output.length()-1;i++)
        {
            if((Character.isUpperCase(temp.charAt(i))))
            {
                    .toUpperCase();
            }
            
        }
        System.out.println(output);
    }
    public static void main()
    {
        Ceaser_cipher obj=new Ceaser_cipher();
        obj.input();
        obj.Calculate();
    }
}
    /**
     Step 1:start
     Step 2:Input string and convert to uppercase.Input shift.
     Step 3:If sum of shift and ascii value is >90,subtract 26 from sum.
     Step 4:If sum of shift and ascii value is <90,add 26 from sum.
     step 5:If it's not the case in step 4 or 5.display sum as character
     Step 6:Output the final string
     step 7:End
     */
        