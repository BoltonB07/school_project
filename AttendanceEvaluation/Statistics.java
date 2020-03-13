package AttendanceEvaluation;

import java.io.*;
/**
 * Write a description of class Correlation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Statistics
{
    double Correlation(int[] xx,int[] yy){           //x and y array lengths have to be equal to perform task
        int[] x,y,xy,x2,y2;
        int n=xx.length,Sigx=0,Sigy=0,Sigxy=0,Sigx2=0,Sigy2=0;
        double r=0;
        x=new int[n];
        y=new int[n];
        xy=new int[n];
        x2=new int[n];
        y2=new int[n];
        for(int i=0;i<=n-1;i++){              //Initializes x and y array with input values
            x[i]=xx[i];
            y[i]=yy[i];
        }
        for(int j=0;j<=n-1;j++){
            xy[j]=x[j]*y[j];
            x2[j]=x[j]*x[j];
            y2[j]=y[j]*y[j];
        }
        for(int k=0;k<=n-1;k++){
            Sigx+=x[k];
            Sigy+=y[k];
            Sigxy+=xy[k];
            Sigx2+=x2[k];
            Sigy2+=y2[k];
        }
        r=((n*Sigxy)-(Sigx*Sigy))/(Math.pow((n*Sigx2)-(Math.pow(Sigx,2))*((n*Sigy2)-(Math.pow(Sigy,2))),0.5));
        return r;
    }
}
