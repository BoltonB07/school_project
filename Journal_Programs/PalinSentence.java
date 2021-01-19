package Journal_Programs;

import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class PalinSentence {
    String str;
    PalinSentence(String str){
        this.str=str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String str = sc.nextLine().toUpperCase();
        PalinSentence o = new PalinSentence(str);
        o.palindrome();
    }

    void palindrome(){
        StringTokenizer st = new StringTokenizer(str);
        String[] arr = new String[st.countTokens()];
        for(int i=0;i<=arr.length-1;i++)
            arr[i]=st.nextToken();
        for(int i=0;i<= arr.length-1;i++){
            out.print(arr[i]);
            for(int j = arr[i].length() - 2; j > -1; j--){
                out.print(arr[i].charAt(j));
            }
            out.print(" ");
        }
    }
}