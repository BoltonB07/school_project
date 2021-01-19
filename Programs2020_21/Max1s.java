package Programs2020_21;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Algo:
 * 1. Start
 * 2. Take an 2-D sorted array int[][] arr input from the user.
 * 3. Initialize an array int[] count to keep the number of 1s in each row
 * 4. Run loops to go through each row of array arr and count the number of 1s.
 *      for(int i=0;i<=arr.length-1;i++){
 *             for(int j=0;j<=arr[i].length-1;j++){
 *                 if(arr[i][j]==1)
 *                     count[i]++;
 *             }
 *         }
 * 5. Check which element number of count array is maximum, and then print that element number as the row number with maximum 1s.
 * 6. End
 */
public class Max1s {
    int[][] arr;
    Max1s(int[][] arr){
        this.arr=arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(in);
        int[][] arr;
        out.println("Please enter the order of the matrix");
        int order=sc.nextInt();
        arr=new int[order][order];
        out.println("Please enter the values for a sorted matrix.");
        for(int i=0;i<=arr.length-1;i++) {
            for (int j = 0; j <= arr[i].length - 1; j++)
                arr[i][j] = sc.nextInt();
        }
        Max1s obj = new Max1s(arr);
        obj.checkAndPrint();
    }
    void checkAndPrint(){
        int[] count=new int[arr.length];
        //initializing with 0s
        for(int i=0;i<=count.length-1;i++){
            count[i]=0;
        }
        //counting the number of 1s
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++){
                if(arr[i][j]==1)
                    count[i]++;
            }
        }
        //to find the row number with max number of 1s
        int max=0,maxPos=0;
        for(int i=0;i<=count.length-1;i++){
            if(count[i]>max){
                maxPos=i;
                max=count[i];
            }
        }
        //printing the matrix
        for(int i =0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++){
                out.print(arr[i][j]+"\t");
            }
            out.println();
        }
        //printing the row number
        out.println("Maximum 1s is at row number "+maxPos);
    }
}
