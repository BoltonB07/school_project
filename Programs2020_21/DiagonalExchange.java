package Programs2020_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class DiagonalExchange {
    int[][] arr;

    DiagonalExchange(int[][] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        out.println("Enter the order of the matrix");
        int order = sc.nextInt();
        int[][] arr = new int[order][order];
        //input
        out.println("Enter the elements");
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                arr[i][j] = Integer.parseInt(br.readLine());
        }
        DiagonalExchange o = new DiagonalExchange(arr);
        o.calc();
        o.print();
    }

    void calc() {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        //storing the left diagonal
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                if (i == j)
                    left[i] = arr[i][j];
        }
        //storing the right diagonal
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                if (i == (arr.length - 1 - j))
                    right[i] = arr[i][j];
        }
        //putting the right diagonal elements into the left diagonal
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                if (i == j)
                    arr[i][j] = right[i];
        }
        //putting the left diagonal elements into the right diagonal
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                if (i == (arr.length - 1 - j))
                    arr[i][j] = left[i];
        }
    }

    void print() {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                out.print(arr[i][j] + "\t");
            out.println();
        }
    }
}
