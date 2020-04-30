package com.rahil.SortGraph;

public class Sort {
    int[] Bubble(int[] A){
        int temp;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length-i;j++){
                if(A[j-1]>A[j]){
                    temp=A[j-1];
                    A[j-1]=A[j];
                    A[j]=temp;
                }
            }
        }
        return A;
    }
    int[] Insertion(int[] A){
        int temp;
        for(int i=0;i<A.length;++i){
            int element = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > element) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = element;
        }
        return A;
    }
    int[] Selection(int[] A){

        return A;
    }
    int[] Merge(int[] A){

        return A;
    }
    int[] Quick(int[] A) {

        return A;
    }
}
