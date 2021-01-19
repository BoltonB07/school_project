package Journal_Programs;

/*
  1. Start
  2. Put the non-boundary elements in an array
  3. Sort them using Bubble Sort
  4. Put them back in the array.
  5. Run a loop to take the sum of primary diagonal
  6. Run a loop to take the sum of the secondary diagonal
  7. Print the original, rearranged and diagonal arrays
  8. End
 */

import java.util.Scanner;

public class Q2_2016 {
    int[][] arr;
    int[][] og;
    int sum=0;

    Q2_2016(int[][] arr) {
        this.arr = arr;
        og = this.arr;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        System.out.println("Enter the elements of array");
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++)
                arr[i][j] = sc.nextInt();
        }
        Q2_2016 o = new Q2_2016(arr);
        o.sort();
        o.diagonal();
        o.display();
    }

    void sort() {
        //Taking out the elements
        int[] nonBound = new int[(arr.length - 2) * (arr[0].length - 2)];
        for (int i = 1; i <= arr.length - 2; i++) {
            int count=0;
            for (int j = 1; j <= arr[i].length - 2; j++) {
                nonBound[count] = arr[i][j];
                count++;
            }
        }
        //Sorting the elements
        int temp;
        for (int i = 0; i < nonBound.length - 1; i++) {
            for (int j = i + 1; j < nonBound.length; j++) {
                if (nonBound[i] > nonBound[j]) {
                    temp = nonBound[i];
                    nonBound[i] = nonBound[j];
                    nonBound[j] = temp;
                }
            }
        }
        //Putting them back
        for (int i = 1; i <= arr.length - 2; i++) {
            int count=0;
            for (int j = 1; j <= arr[i].length - 2; j++) {
                nonBound[count] = arr[i][j];
                count++;
            }
        }
    }

    void diagonal() {
        int sum = 0;
        //Primary diagonal
        for (int i = 0, j = 0; i <= arr.length - 1; i++, j++) {
            sum += arr[i][j];
        }
        //Secondary Diagonal
        if (arr.length % 2 == 0) {
            //odd
            for (int j = arr.length - 1, i = 0; i <= arr.length - 1; i++, j--) {
                if ((arr.length / 2) + 1 != i)
                    sum += arr[i][j];
            }
        } else {
            for (int j = arr.length - 1, i = 0; i <= arr.length - 1; i++, j--) {
                sum += arr[i][j];
            }
        }
        this.sum=sum;
    }

    void display() {
        //original
        System.out.println("Original array");
        print(og);
        //rearranged
        System.out.println("Rearranged array");
        print(arr);
        //diagonals
        System.out.println("diagonals");
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - 1; j++) {
                if (i == j || i + j == arr.length - 1)
                    System.out.print(arr[i][j] + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("Sum of the diagonals = " + sum);
    }

    void print(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr.length - 1; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
}