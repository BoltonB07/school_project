package Journal_Programs;

import java.util.Scanner;

import static java.lang.System.*;

public class SingleMultiArray {
    int[] a;int[][] b;int n;
    SingleMultiArray(int[] a,int[][] b,int n){
        this.a=a;
        this.b=b;
        this.n=n;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(in);
        out.println("Enter the order of the arrays");
        int n=sc.nextInt();
        int[] a=new int[n];
        int[][] b= new int[n][n];
        out.println("Enter the array elements");
        for(int i=0;i<=a.length-1;i++)
            a[i] = sc.nextInt();
        SingleMultiArray o = new SingleMultiArray(a,b,n);
        o.sort();
        o.fillMatrix();
    }
    void sort(){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    void fillMatrix(){
        int x=1;
        for(int i =0;i<=b.length-1;i++,x++){
            for(int j=0;j<=b.length-x;j++) {
                b[i][j] = a[j];
                out.print(b[i][j]+"\t");
            }
            for(int j=0;j<=x-2;j++) {
                b[i][j] = a[j];
                out.print(b[i][j]+"\t");
            }
            out.println();
        }
    }
}
