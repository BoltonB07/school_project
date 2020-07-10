package Journal_Programs;

import java.util.Scanner;

public class BoundDiag {
    int[][] arr;
    BoundDiag(int[][] arr){
        this.arr=arr;
    }
    int findSum(){
        int sum=0;
        for(int i=0;i<=arr[0].length-1;i++){sum+=arr[0][i];}
        for(int i=0;i<=arr[arr.length-1].length-1;i++){sum+=arr[arr.length-1][i];} //FIRST AND LAST ROW
        for(int i=1;i<=arr.length-2;i++){ //MIDDLE ROWS
            for(int j=0;j<=arr[i].length-1;j++){
                if(j==0||j==arr[i].length-1)
                    sum+=arr[i][j];
            }
        }
        for(int i=1,j=1;i<=arr.length-2;i++,j++){sum+=arr[i][j];}//PRIMARY DIAGONAL
        for(int i=1,j=arr[0].length-2;i<=arr.length-2;i++,j--){if(i==arr.length/2){continue;} //SECONDARY DIAGONAL
            sum+=arr[i][j];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr=new int[5][5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        BoundDiag o = new BoundDiag(arr);
        System.out.println("The sum is: "+o.findSum());

    }
}
