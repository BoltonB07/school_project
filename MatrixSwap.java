import java.util.*;
/**
 * Write a description of class MatrixSwap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixSwap
{
    int[][] arr;
    MatrixSwap(int i,int j){
        arr=new int[i+1][j];
    }
    void krijgInformatie(){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++)
            arr[i][j]=sc.nextInt();
            if(i==arr.length-1){
                for(int k=0;k<=arr[i].length-1;k++){
                    arr[i][k]=0;
                }
            }
        }
        System.out.println("Het origineel array is:");
        afdrukken();
    }
    void Swappen(){
        for(int i=0;i<arr.length-1;i++){
            arr[arr.length-1]=arr[i];
            arr[i+1]=arr[arr.length-1];
            i++;
        }
        System.out.println("The swapped array is:");
        afdrukken();
    }
    void afdrukken(){
        for(int i=0;i<=arr.length-1;i++){
            for(int j=0;j<=arr[i].length-1;j++){
                System.out.println(arr[i][j]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    public static void main(){
        MatrixSwap obj=new MatrixSwap(4,4);
        obj.krijgInformatie();
        obj.Swappen();
    }
}