package Journal_Programs;

import java.util.Scanner;

public class MatrixSort {
    int[][] arr;
    MatrixSort(int[][] arr){
        this.arr=arr;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter matrix size");
        int n = sc.nextInt();
        System.out.println("Enter matrix elements");
        int[][] arr = new int[n][n];
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        MatrixSort o = new MatrixSort(arr);
        System.out.println("Original Matrix");
        o.display();
        System.out.println("Matrix after sorting rows");
        o.sort();
        o.display();
    }
    void sort(){ //using Bubble Sort
        for(int i =0;i<=arr.length-1;i++){
            for(int j=0;j<arr[i].length-1;j++){
                for(int k=0;k<arr[i].length-j-1;k++){
                    if(arr[i][k]>arr[i][k+1]){
                        int temp = arr[i][k];
                        arr[i][k] = arr[i][k+1];
                        arr[i][k+1]=temp;
                    }
                }
            }
        }
    }
    void display(){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println();
        }
    }
}