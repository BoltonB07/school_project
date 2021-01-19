/*
  1  Start
  2. Transfer String to array
  3. In Loop 1, check if vowel, then print it.
  4. In Loop 2, check if not vowel, then print it.
  5. End
 */
package Journal_Programs;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3_2016 {
    String s;

    Q3_2016(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        Q3_2016 o = new Q3_2016(s);
        o.vowelSentence();
    }

    void vowelSentence() {
        StringTokenizer st = new StringTokenizer(s, " .!?");
        String[] sentence = new String[st.countTokens()];
        for (int i = 0; i <= sentence.length - 1; i++) {
            sentence[i] = st.nextToken();
        }
        for (int i = 0; i <= sentence.length - 1; i++) {
            if (isVowel(sentence[i])) {
                System.out.print(sentence[i] + " ");
            }
        }
        for (int i = 0; i <= sentence.length - 1; i++) {
            if (!isVowel(sentence[i])) {
                System.out.print(sentence[i] + " ");
            }
        }
    }

    boolean isVowel(String s) {
        return ((s.charAt(0) == 'A' || s.charAt(0) == 'E' || s.charAt(0) == 'I' || s.charAt(0) == 'O' || s.charAt(0) == 'U') && (s.charAt(s.length() - 1) == 'A' || s.charAt(s.length() - 1) == 'E' || s.charAt(s.length() - 1) == 'I' || s.charAt(s.length() - 1) == 'O' || s.charAt(s.length() - 1) == 'U'));
    }
}