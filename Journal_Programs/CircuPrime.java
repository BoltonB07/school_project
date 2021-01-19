package Journal_Programs;

import java.util.Scanner;

/*
    1. Start.
    2. Check if original number is a prime number or not
    3. Initialize a flag variable
    4. Run a infinite loop where the last character gets added to the front and then it's checked for being a prime number.
    5. When the new number becomes the same as the original number, break the loop.
    6. If flag is true, then the input number is Circular Prime, if not, then it's not.
    7. End.
 */
public class CircuPrime {
    int n;

    CircuPrime(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CircuPrime o = new CircuPrime(n);
        o.check();
    }

    void check() {
        int circularN = n;
        boolean flag = true;
        if (!checkPrime(n))
            flag = false;
        else {
            System.out.println(circularN);
            while (true) {
                String num1 = String.valueOf(circularN);
                num1 = num1.charAt(num1.length() - 1) + num1.substring(0, num1.length() - 1);
                circularN = Integer.parseInt(num1);
                if (!checkPrime(circularN)) {
                    flag = false;
                    break;
                }
                if (circularN == n) {
                    break;
                }
                System.out.println(circularN);
            }
        }
        if (flag) {
            System.out.println(n + " is a Circular Prime number");
        } else {
            System.out.println(n + " is not a Circular Prime number");
        }
    }

    boolean checkPrime(int n) {
        boolean flag = true;
        for (int i = 2; i <= (n / 2) + 1; i++) {
            int temp1 = n / i;
            int temp2 = temp1 * i;
            if (temp2 == n) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
