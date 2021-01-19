package Programs2020_21;

import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 1. Start
 * 2. Accept the String input
 * 3. Store each word in an array
 * 4. with each element, print the first and last charater using String.substring and charAt()
 * arr[i].charAt(arr[i].length()-1)+arr[i].substring(1,arr[i].length()-1)+arr[i].charAt(0)+" "
 * 5. Use a loop to do this to all elements and then print it
 * 6. End
 */
public class Exchange { //constructor
    String str;

    Exchange(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.println("Enter sentence");
        String str = sc.nextLine();
        Exchange o = new Exchange(str);
        o.calc();
    }

    void calc() {
        StringTokenizer st = new StringTokenizer(str);
        String[] arr = new String[st.countTokens()];
        Scanner sentence = new Scanner(str);
        for (int i = 0; sentence.hasNext(); i++)
            arr[i] = sentence.next(); //transferring the words into the String array
        //prints the last char, then the middle chars and then the first char
        for (int i = 0; i <= arr.length - 1; i++)
            out.print(arr[i].charAt(arr[i].length() - 1) + arr[i].substring(1, arr[i].length() - 1) + arr[i].charAt(0) + " ");
    }
}