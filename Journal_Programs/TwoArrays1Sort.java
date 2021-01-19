package Journal_Programs;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TwoArrays1Sort {
    int[] a, b;

    TwoArrays1Sort(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.println("Enter the size for the 1st array");
        int[] a = new int[sc.nextInt()];
        out.println("Enter the size for the 2nd array");
        int[] b = new int[sc.nextInt()];
        out.println("Enter the elements for the 1st array");
        for (int i = 0; i <= a.length - 1; i++)
            a[i] = sc.nextInt();
        out.println("Enter the elements for the 2nd array");
        for (int i = 0; i <= b.length - 1; i++)
            b[i] = sc.nextInt();
        TwoArrays1Sort o = new TwoArrays1Sort(a, b);
        o.combineSortPrint();
    }

    void combineSortPrint() {
        int[] arr = new int[a.length + b.length];
        for (int j = 0; j <= a.length - 1; j++)
            arr[j] = a[j];
        for (int j = 0; j <= b.length - 1; j++)
            arr[j + b.length] = b[j];
        //Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i <= arr.length - 1; i++)
                out.print(arr[i] + " ");
    }
}
