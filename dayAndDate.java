import java.util.*;
/**
 * Takes day number as input and provides a full format date as output
 *
 * @author @boltonb07 (Twitter)
 * @version 0.0.1 Alpha Testing
 */
public class dayAndDate
{
        dayAndDate(int d_){
            int d=d_;
            final int n=d;
            int i=0;
            int m,y=2019;
        }
        void calc(){
                m=d/30;
                d=d-(m*30);
        }
        void dispRes(){
            System.out.println("The number you put in was:"+n+"\n The days in dd/mm/yyyy format is:"+d+"/"+m+"/"+y);
        }
        void main(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a day number");
            int d$=sc.nextInt();
            dayAndDate o=new dayAndDate(d$);
            o.calc();
            o.dispRes();
        }
}
