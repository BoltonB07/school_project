package Journal_Programs;

import java.util.Scanner;

public class FashionSentence {
    int a,b; String input;
    FashionSentence(int a$,int b$, String input$){
        a=a$;
        b=b$;
        input=input$;
    }

    void calc(){
        if(a==b){cycleChar(a,input);}
        else{
            cycleChar(a,input);
            cycleChar(b,input);
        }
        System.out.println(input);
    }
    void cycleChar(int number,String inputString){
        Scanner sc=new Scanner(inputString);
        Scanner sc2=new Scanner(inputString);
        int counter=0;
        while(counter<number){
            sc.next();
            counter++;
        }
        String temp1=sc.next();
        String temp2=temp1;
        StringBuilder myString = new StringBuilder(temp2);

        for(int i=0;i<=temp2.length()-1;i++){
            if(temp2.charAt(i)=='z'){myString.setCharAt(i, 'a');}
            else if(temp2.charAt(i)=='Z'){myString.setCharAt(i, 'A');}
            else {
                myString.setCharAt(i, (char) ((int)(temp2.charAt(i)) + 1));
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string then enter 2 ints");
        String input = sc.nextLine();
        int a=sc.nextInt();
        int b=sc.nextInt();
        FashionSentence obj=new FashionSentence(a,b,input);
        obj.calc();


    }
}
