 

import java.util.*;
/**
 * Write a description of class Matrices here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrices
{
    int[][] a,b,fin;int rows;
    Matrices(int row){
        a=new int[row][row];
        b=new int[row][row];
        rows=row;
    }
    void init(){
        Scanner sc=new Scanner(System.in);
        int rownum;
        System.out.println("Enter the values of array a");
        for(int i=0;i<=rows-1;i++){
            rownum=i+1;
            System.out.println("Row "+i);
            for(int j=0;j<=rows-1;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the values of array b");
        for(int i=0;i<=rows-1;i++){
            rownum=i+1;
            System.out.println("Row "+i);
            for(int j=0;j<=rows-1;j++){
                b[i][j]=sc.nextInt();
            }
        }
    }
    void choice(){
        Scanner sc=new Scanner(System.in);
        System.out.println("What do ya wanna do?\n1)Add\n2)Multiply");
        int choice=sc.nextInt();
        if(choice==1){
            fin=Matrix1.add(a,b);
            print(fin);
        }
        else if(choice==2){
            fin=Matrix1.multiply(a,b);
            print(fin);
        }
        else{
            System.out.println("Wrong option; have another go.");
            choice();
        }
    }
    void print(int[][] mat){
        for(int i=0;i<=rows-1;i++){
            System.out.print("|");
            for(int j=0;j<=rows-1;j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println("|");
        }
    }
    public static void main(String[] foo){
        Scanner sc=new Scanner(System.in);
        System.out.println("How many rows and columns? (Will be a square [ixi] and same for both matrices)");
        int rowslol=sc.nextInt();
        Matrices m=new Matrices(rowslol);
        m.init();
        m.choice();
    }
}