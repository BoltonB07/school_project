package Journal_Programs;

import java.util.Scanner;

import static java.lang.System.*;

public class EvilNumber {
    int n;
    EvilNumber(int n){
        this.n=n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n =sc.nextInt();
        EvilNumber o = new EvilNumber(n);
        out.println((o.check(o.BinaryConvert(n)))?"EVIL NUMBER":"NOT AN EVIL NUMBER");
    }

    StringBuffer BinaryConvert(int n){
        String binary = "";
        while(n>=1){
            binary= binary.concat(String.valueOf(n%2));
            n/=2;
        }
        StringBuffer sb = new StringBuffer(binary);
        sb.reverse();
        return sb;
    }
    boolean check(StringBuffer n){
        int count=0;
        for(int i=0;i<=n.length()-1;i++){
            if(n.charAt(i)=='1')
                count++;
        }
        if(count%2==0)
            return true;
        else
            return false;
    }
}
