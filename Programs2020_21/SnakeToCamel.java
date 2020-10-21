package Programs2020_21;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 1) Start
 * 2) Input the snake case
 * 3) Use StringTokenizer with delimiter "_"
 * 4) Then use a loop to store tokens in a String array
 * 5) Convert all letters to lower case in the array
 * 6) then convert the first character of 2nd letter onwards to upper case
 * 7) Print the array elements using System.out.print();
 * 8) End
 */
public class SnakeToCamel { String input; String[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter in Snake Case");
        String input=sc.nextLine();
        SnakeToCamel obj = new SnakeToCamel(input);
        obj.words();
        obj.display();
    }
    SnakeToCamel(String input){
        this.input=input;
    }
    void words(){
        StringTokenizer st = new StringTokenizer(input,"_");
        arr = new String[st.countTokens()];
        for(int i = 0; i<=arr.length-1;i++){
            arr[i]=st.nextToken();
            if(i==0)
                arr[i]=arr[i].toLowerCase();
            else
                arr[i]= Character.toUpperCase(arr[i].charAt(0))+arr[i].substring(1);
        }
    }
    void display(){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]);
        }
    }

}
