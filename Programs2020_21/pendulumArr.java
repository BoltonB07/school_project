package Programs2020_21;

import java.util.Scanner;

/**
 * Write a description of class pendulumArr here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pendulumArr {
    int[] arr;

    pendulumArr(int n) {
        arr = new int[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements?");
        pendulumArr o = new pendulumArr(sc.nextInt());
        o.input();
        o.sort();
        o.pendPrint();
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void sort() {
        for (int i = 0; i <= arr.length - 2; i++)
            for (int j = 0; j <= arr.length - 2 - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    void pendPrint() {
        boolean isLeft = true;
        boolean isEven = arr.length % 2 == 0;
        for (int i = arr.length - 1; ; ) {
            System.out.print(arr[i] + " ");
            if (isLeft) {
                if (i > 1) {
                    i -= 2;
                    if (i == 0)
                        isLeft = false;
                } else if (i == 1) {
                    i--;
                    isLeft = false;
                }
            } else {
                if (isEven && i + 2 < arr.length - 1)
                    i += 2;
                else {
                    if (i + 2 >= arr.length - 1) {
                        break;
                    }
                    if (i == 0)
                        i++;
                    else
                        i += 2;

                }
            }
        }
    }
}