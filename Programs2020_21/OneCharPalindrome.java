package Programs2020_21;

import java.util.Scanner;

/**
 * 1) Start
 * 2) Take String input
 * 3) Run a loop with counters going from both ends of the loop like: for(int i=0,j=str.length()-1;i<=(str.length()-1)/2;i++)
 * 4) int palinCount=0;
 * 5) if(str.charAt(i)!=str.charAt(j)) then palinCount++ and pointerLeft = i and pointerRight = j
 * 6) if palinCount > 1 then break;
 * 7)    //the following is outside of loop
 * 8) if palinCount = 1 then we  print ("Can be palindrome if we change str.charAt(i) to str.charAt(j)")
 * 9) if palinCount = 0 then we print "already palindrome"
 * 10) if palinCount >1 then we print "can't be palindrome if we change 1 letter"
 * 11) End
 */
public class OneCharPalindrome { String str;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine();
        OneCharPalindrome obj = new OneCharPalindrome(str);
        obj.checkPalin();
    }
    OneCharPalindrome(String str){
        this.str=str;
    }
    void checkPalin() {
        int palinCount = 0, pointerLeft = 0, pointerRight = 0;
        for (int i = 0, j = str.length() - 1; i <= (str.length() - 1)/2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                palinCount++;
                pointerLeft = i;
                pointerRight = j;
            }
            if (palinCount > 1) {
                break;
            }
        }
        if (palinCount==1) {
            System.out.println(str+ " can be a palindrome if we change 1 letter (changing \""+str.charAt(pointerLeft)+"\" to \""+str.charAt(pointerRight)+"\" or "+"\""+str.charAt(pointerRight)+"\" to \""+str.charAt(pointerLeft)+"\")");
            makePalin(pointerLeft,pointerRight);
        }
        else if(palinCount==0)
            System.out.println(str+" is already a palindrome");
        else
            System.out.println("We need to change "+palinCount+" letters to make "+str+" a palindrome");
    }

    void makePalin(int pointerLeft, int pointerRight){
        StringBuffer sb1 = new StringBuffer(str);
        StringBuffer sb2 = new StringBuffer(str);
        String Palin1, Palin2;
        Palin1= String.valueOf(sb1.replace(pointerLeft, pointerLeft+1, String.valueOf(sb1.charAt(pointerRight))));
        Palin2= String.valueOf(sb2.replace(pointerRight, pointerRight+1, String.valueOf(sb2.charAt(pointerLeft))));
        System.out.println(Palin1+" and "+Palin2+".");
    }

}
