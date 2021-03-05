package Programs2020_21;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 1. Start.
 * 2. Accept a sentence.
 * 3. Each character of the words of the sentence to a char[] array c using s.charAt(i) in a for loop.
 * 4. Increment a value if it's a vowel and decrement a value if it's a consonant.
 * 5. Print the character using out.print() so that they are on the same line.
 * 6. End.
 */
public class ASCIIvalue {
    String s;
    ASCIIvalue(String s){
        this.s=s;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(in);
        out.println("Enter String");
        String s = sc.nextLine().toLowerCase();
        ASCIIvalue o =new ASCIIvalue(s);
        o.process();
    }
    void process(){
        char[] c=new char[s.length()] ;
        for(int i=0;i<=s.length()-1;i++){
            c[i]=s.charAt(i);
            if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u') {
                c[i]++;
            }
            else {
                c[i]--;
            }
            out.print(c[i]);
        }
    }
}
