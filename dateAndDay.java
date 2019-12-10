import java.util.*;
/**
 * Takes a full format date as input and provides a day number for the corresponding date as output.
 *
 * @author @boltonb07 (Twitter)
 * @version 0.0.1 Alpha Testing
 */
public class dateAndDay
{
    dateAndDay(int d_,int m_){
        int d=d_,m=m_;
        int n;
    }

    void calc(){
        n=m*30+d;
    }

    void dispRes(){
        System.out.println("The date you entered in dd/mm/yyyy format is: "+d+"/"+m+"/2019"+"\nThe day number for the given date is: "+n);
    }

    void main(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dd portion of a full format date:");
        int d$=sc.nextInt();
        System.out.println("Enter the mm portion of a full format date:");
        int m$=sc.nextInt();
        System.out.println("We are assuming that you are in 2019");
        dateAndDay o=new dateAndDay(d$,m$);
        o.calc();
        o.dispRes();
    }
}