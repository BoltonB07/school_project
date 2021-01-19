package Journal_Programs;
/*Program works correctly, ready to be journaled*/
import java.util.Scanner;

public class Caesar {
    String str;char[] arr;
    Caesar(String str){
        this.str=str;
        arr = new char[str.length()];
    }
    void cipher(){
        for(int i=0;i<=str.length()-1;i++){
            arr[i]=str.charAt(i);
        }
        for(int i =0; i<=arr.length-1;i++){
            if(i>=65&&i<=90){
                if(arr[i]+13<90)
                    arr[i]+=13;
                else
                    arr[i]= (char) (arr[i]+13-26);
            }
            else{
                if(arr[i]+13<122)
                    arr[i]+=13;
                else
                    arr[i]= (char) (arr[i]+13-26);
            }
        }
    }
    void display(){
        for(int i=0;i<=arr.length-1;i++)
            System.out.print(arr[i]);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Caesar o= new Caesar(sc.nextLine());
        o.cipher();
        o.display();
    }
}
