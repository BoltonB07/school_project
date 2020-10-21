package Programs2020_21;

import java.util.Scanner;

/**
 * WAP to accept 5 elements in an array and sort them using selection sort techniquesOr Bubble sortOr Insertion sort.
 */

public class BubbleSort { int[] arr;
    BubbleSort(int[] arr){ //constructor
        this.arr=arr;
    }

    void sort(){ //This method sorts the array using the bubble sort technique
        for(int i=0; i<=arr.length-2;i++){
            for(int j=0;j<=arr.length-(i+1)-1;j++){
                if (arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    void display(){ //This method displays the sorted array
        for(int i=0;i<=arr.length-1;i++)
            System.out.print(i!=arr.length-1?(arr[i]+", "):(arr[i]+"."));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 5 numbers to be sorted with Bubble Sort");
        int[] arr =new int[5];
        for(int i=0;i<=arr.length-1;i++)
            arr[i]=sc.nextInt();
        BubbleSort obj=new BubbleSort(arr);
        obj.sort();
        obj.display();
    }
}
