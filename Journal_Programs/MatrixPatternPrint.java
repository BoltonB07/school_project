package Journal_Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class MatrixPatternPrint {
    String[][] arr;
    String a, b, c;
    int n;

    MatrixPatternPrint(String[][] arr, String a, String b, String c, int n) {
        this.arr = arr;
        this.a = a;
        this.b = b;
        this.c = c;
        this.n = n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out.println("Enter the size of the matrix:");
        int n = Integer.parseInt(br.readLine());
        out.println("Enter first character:");
        String a = br.readLine();
        out.println("Enter second character:");
        String b = br.readLine();
        out.println("Enter third character:");
        String c = br.readLine();
        String[][] arr = new String[n][n];
        MatrixPatternPrint o = new MatrixPatternPrint(arr, a, b, c, n);
        o.FillMatrix();
        o.print();
    }

    void FillMatrix() {
        //Filling with character 1
        arr[0][0] = a;
        arr[0][n - 1] = a;
        arr[n - 1][0] = a;
        arr[n - 1][n - 1] = a;
        //Filling with character 2
        //first line
        for (int i = 0; i <= arr[0].length - 1; i++)
            if (arr[0][i] == null)
                arr[0][i] = b;
        //last line
        for (int i = 0; i <= arr[arr.length - 1].length - 1; i++)
            if (arr[arr.length - 1][i] == null)
                arr[arr.length - 1][i] = b;
        //left column
        for (int i = 0; i <= arr.length - 1; i++)
            if (arr[i][0] == null)
                arr[i][0] = b;
        //right column
        for (int i = 0; i <= arr.length - 1; i++)
            if (arr[i][arr[i].length - 1] == null)
                arr[i][arr[i].length - 1] = b;
        //Filling with character 3
        for (int i = 0; i <= arr.length - 1; i++)
            for (int j = 0; j <= arr[i].length - 1; j++)
                if (arr[i][j] == null)
                    arr[i][j] = c;
    }

    void print() {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                out.print(arr[i][j] + "\t");
            out.println();
        }
    }
}
