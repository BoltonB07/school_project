package Programs2020_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Harsh's program
 */
public class fashion_sentence {
    String str;
    String fina1 = " ";
    int[] pos;

    public static void main(String[] args) throws IOException {
        fashion_sentence obj = new fashion_sentence();
        obj.input();
        obj.getWord();

    }

    public void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the String");
        str = bf.readLine();
        System.out.println("Enter number of positions you want to change");
        int size = Integer.parseInt(bf.readLine());
        pos = new int[size];
        System.out.println("Enter those numbers");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= pos.length - 1; i++) {
            pos[i] = sc.nextInt();
        }
    }

    public void getWord() {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            st.nextToken();
            for (int i = 1, j = 0; i <= st.countTokens(); i++, j++) {
                if (i == pos[j]) {
                    fina1 += circulate(st.nextToken()) + " ";
                }
            }
        }
        System.out.println("Final statement : " + fina1);
    }

    public String circulate(String s) {
        StringBuffer sb = new StringBuffer(s); //to replace characters
        for (int i = 0; i <= s.length() - 1; i++) {
            char a = s.charAt(i);
            sb.replace(i, i + 1, (String.valueOf(a - 25)));
        }
        return sb.toString();
    }
}