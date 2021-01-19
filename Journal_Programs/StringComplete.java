package Journal_Programs;

import java.util.Scanner;

public class StringComplete {
    String[] first, second;

    StringComplete(String[] first, String[] second) {
        this.first = first;
        this.second = second;
    }

    static boolean checkCombi(String a, String b) {
        boolean ifFound = false;
        boolean holdsTrue = false;
        String temp = a.concat(b).toLowerCase();
        for (char i = 97; i <= 122; i++) {
            for (int j = 0; j <= temp.length() - 1; j++) {
                if (i == temp.charAt(j)) {
                    ifFound = true;
                    break;
                }
            }
            if (ifFound) {
                holdsTrue = true;
                ifFound = false;
                continue;
            } else {
                holdsTrue = false;
                break;
            }
        }
        return holdsTrue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 strings for first set");
        String[] a = new String[4];
        for (int i = 0; i <= a.length - 1; i++)
            a[i] = sc.nextLine();
        System.out.println("Enter 3 strings for second set");
        String[] b = new String[3];
        for (int i = 0; i <= b.length - 1; i++)
            b[i] = sc.nextLine();
        StringComplete o = new StringComplete(a, b);
        o.Combi();
    }

    void Combi() {
        for (int i = 0; i <= first.length - 1; i++) {
            for (int j = 0; j <= second.length - 1; j++) {
                if (checkCombi(first[i], second[j]))
                    Print(first[i], second[j]);
            }
        }
    }

    private void Print(String s, String s1) {
        System.out.println("\"" + s + s1 + "\"");
    }
}