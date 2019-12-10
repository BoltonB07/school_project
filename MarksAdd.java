import java.util.*;
/**
 * Takes input of 3 marks and calculates percentage and average and outputs it and returns back and starts gain if input is wrong
 * 
 * @author @boltonb07 (Twitter)
 * @version 0.1.0B Beta public release
 */
public class MarksAdd
{
    int a,b,c; static int e=0;
    float perc, avg;
    void inputMarks(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the 3 marks (each one out of 100)");
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        if(a>100||a<0||b>100||b<0||c>100||c<0)
        {
            System.out.println("That wasn't a proper input; please try again.");
            e=1;
        }
    }

    void calcPercentage(){
        perc=(a+b+c)/3;
    }

    void calcAverage(){
        avg=(a+b+c)/3;
    }

    void dispResult(){
        System.out.println("So, here is the long awaited result that you have been waiting for \npercentage:"+perc+"\naverage:"+avg);
    }
    
    public static void main(){
        MarksAdd o=new MarksAdd();
        o.inputMarks();
        if(e==1){
            o.main();
        }
        o.calcPercentage();
        o.calcAverage();
        o.dispResult();
    }
}
