package com.rahil.SortGraph;
/**
 * Only call the methods which are public. Some methods, which are declared as private is for internal use.
 * IMPORTANT NOTE: Please cross-check for errors/bugs. Also, please check the places where iterations have been
 * incremented. Because if it is incremented in wrong places, it will give us an inaccurate output.
 * I have marked the places where I have incremented with, "//incremented here". Or you could just use Ctrl+F to find.
 * Currently, it does 5 kinds of sorting: Bubble, Insertion, Selection, Merge, Quick.
 * */
public class Sort {
    public int Bubble(int[] A){
        int temp,iterations=0;
        for (int i=0;i<A.length-1-1;i++){
            for (int j=0;j<A.length-1-i-1;j++){
                iterations++;           //incremented here
                if (A[j]>A[j+1]){
                    temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
            }
        }
        return iterations;
    }
    public int Insertion(int[] A){
        int iterations=0;
        for(int i=0;i<A.length;++i){

            int element = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > element) {
                iterations++;           //incremented here
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = element;
        }
        return iterations;
    }
    public int Selection(int[] A){
        int min_index,temp,iterations=0;
        for (int i = 0; i < A.length-1; i++){
            min_index=i;
            for (int j = i+1; j < A.length; j++) {
                iterations++;           //incremented here
                if (A[j] < A[i])
                    min_index = j;
            }
            temp = A[min_index];
            A[min_index] = A[i];
            A[i] = temp;
        }
        return iterations;
    }
    public int Merge(int[] A){
        return mergeSort(A,0,A.length-1);
    }
    private int mergeSort(int[] A,int beg, int end){
        int mid,iterations=0;
        if(beg<end)
        {
            iterations++;           //incremented here
            mid = (beg+end)/2;
            mergeSort(A,beg,mid);
            mergeSort(A,mid+1,end);
            iterations=merge(A,beg,mid,end,iterations);
        }
        return iterations;
    }
    private int merge(int[] arr, int beg, int mid, int end, int iterations){
        int l = mid - beg + 1;
        int r = end - mid;
        int[] LeftArray = new int [l];
        int[] RightArray = new int [r];
        for (int i=0; i<l; ++i){
            iterations++;           //incremented here
            LeftArray[i] = arr[beg + i];
        }
        for (int j=0; j<r; ++j){
            iterations++;           //incremented here
            RightArray[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r){
            iterations++;           //incremented here
            if (LeftArray[i] <= RightArray[j]){
                arr[k] = LeftArray[i];
                i++;
            }
            else{
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l){
            iterations++;           //incremented here
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j<r){
            iterations++;           //incremented here
            arr[k] = RightArray[j];
            j++;
            k++;
        }
        return iterations;
    }
    public int Quick(int[] A){
        int iterations=0;
        quicksort(A, 0, A.length-1,iterations);
        return iterations;
    }
    private int quicksort(int[] arr, int low, int high, int iterations){
        if (low < high){
            iterations++;           //incremented here
            int[] receiveArray = partition(arr, low, high,iterations);
            int pi=receiveArray[0];
            quicksort(arr, low, pi-1,iterations);
            quicksort(arr, pi+1, high,iterations);
            return receiveArray[1];
        }
        return iterations;
    }
    private int[] partition(int[] arr, int low, int high, int iterations){
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++){
            iterations++;           //incremented here
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return new int[]{i+1,iterations};
    }
}
