import java.util.*;
/**
 * Write a description of class clothes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class clothes
{
    static int init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a corporation name");
        String s= sc.nextLine();
        s=s.toLowerCase();
        if(s.contains("air")){
            return 1;
        }
        else if(s.contains("boe")){
            return 2;
        }
        else if(s.contains("emb")){
            return 3;
        }
        else if(s.contains("bomb")){
            return 4;
        }
        else if(s.contains("aero")||s.contains("atr")){
            return 5;
        }
        else if(s.contains("bac")){
            return 6;
        }
        else if(s.contains("das")){
            return 7;
        }
        else if(s.contains("mc")){
            return 8;
        }
        else if(s.contains("com")){
            return 9;
        }
        else{
            System.out.println("RETRY");
            init();
            return 10;

        }
    }
}
