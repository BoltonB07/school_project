package Journal_Programs;

import java.util.Scanner;

public class SMS { char[][] keypad; String input;
SMS(String input$){
    keypad = new char[8][];
    input=input$;
    keypad[0]= new char[]{'a','b','c'};
    keypad[1]= new char[]{'d','e','f'};
    keypad[2]= new char[]{'g','h','i'};
    keypad[3]= new char[]{'j','k','l'};
    keypad[4]= new char[]{'m','n','o'};
    keypad[5]= new char[]{'p','q','r','s'};
    keypad[6]= new char[]{'t','u','v'};
    keypad[7]= new char[]{'w','x','y','z'};
}
void calc(){
    char temp;
    for(int i=0; i<=input.length()-1;i++){
        temp=input.charAt(i);
        if(temp==32){System.out.print(0);}
        else{
            for(int j=0;j<=keypad.length-1;j++){
                for(int k=0;k<=keypad[j].length-1;k++){
                    if(temp==keypad[j][k]){
                        printLoop(j,k);
                        break;
                    }
                }
            }
        }
    }
}
void printLoop(int i, int j){
    for(int k=1;k<=j;k++){
        System.out.print(i);
    }
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inputx=sc.nextLine();
        SMS obj=new SMS(inputx);
        obj.calc();
    }
}
