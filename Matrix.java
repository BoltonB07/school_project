 

import java.util.*;
/**
 * Write a description of class addMatrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrix
{
    static int[][] add(int[][] a,int[][] b ){
        for(int i=0;i<=a.length-1;i++){
            for(int j=0;j<=a[i].length-1;j++){
                a[i][j]=a[i][j]+b[i][j];
            }
        }
        return a;
    }
    static int[][] multiply(int[][] a,int[][] b){
        //this method multiplies the 2 matrices
        for(int i=0;i<a.length-1;i++){    //row
            for(int j=0;j<=b[i].length;j++){   //column
                b[i][j]=0;                                //subject to change
                for(int k=0;k<=a[i].length-2;k++){
                    a[i][j]=a[i][j]+a[i][k]*b[k][j];
                }
            }
        }
        return a;
    }
    static int[][] tranpose(int[][] a,int[][] b){
        return a;
    }
    static boolean magicSquare(int[][] a,int[][] b){
        boolean ifMagic=false;
        //make body of the program here
        
        return ifMagic;
    }
}
