import java.util.*;
/**
 * Inputs a number and checks if that number is odd or even or zero.
 *
 * @author Rahil Shaban
 * @version 0.0.1A Alpha Release
 */
public class OddEven
{
    int n; String s;
    void welcome(){
    Scanner sc=new Scanner(System.in);
    System.out.println("Thank you choosing this software over any other software present in abundance\nPress enter to continue.");
    s=sc.nextLine();
    }
    void getInput(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter a number");
            n=sc.nextInt();
            System.out.println("It will take 2MB of RAM and 0.67 GHz of CPU.\nAre you sure you want to continue?\nPress enter to start calculation. ");
            s=sc.nextLine();
        }
        catch(InputMismatchException s){
            System.out.println("You have to enter a number and not anything else, run the preogram again to enter again.");
        }
    }

    void logic(){
        if(n%2==0){
            System.out.println("The number is even and can be divided by 2.");
        }
        else if(n%2==1){
            System.out.println("The number is odd and cannot be divided by 2.");
        }
        else{
            System.out.println("The number is 0.");
        }
    }
    void main(){
        OddEven o = new OddEven();
        o.welcome();
        o.getInput();
        o.logic();
    }
}
