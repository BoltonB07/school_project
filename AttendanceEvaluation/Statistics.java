package AttendanceEvaluation;
/**
 * Write a description of class Correlation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Statistics
{
    double Correlation(double[] x,double[] y){           //x and y array lengths have to be equal to perform task
        double[] xy,x2,y2;
        int n=x.length;
        double Sigx=0,Sigy=0,Sigxy=0,Sigx2=0,Sigy2=0;
        double r=0.0;
        xy=new double[n];
        x2=new double[n];
        y2=new double[n];
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
        r=((n*Sigxy)-(Sigx*Sigy))/(Math.pow(((n*Sigx2)-(Math.pow(Sigx,2)))*((n*Sigy2)-(Math.pow(Sigy,2))),0.5));
        return r;
    }
}
