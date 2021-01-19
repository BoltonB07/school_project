package Journal_Programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Banner {
    String[] str;
    Banner(String[] str){
        this.str=str;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        System.out.println("Enter the number of teams");
        str=new String[Integer.parseInt(br.readLine())];
        System.out.println("Enter the names of the teams");
        for(int i=0;i<=str.length-1;i++){
            str[i]= br.readLine();
        }
        Banner o = new Banner(str);
        o.print();
    }

    void print(){
        int longestIndex=0;
        for(int i = 0;i<=str.length-1;i++){
            if(str[i].length()>str[longestIndex].length())
                longestIndex=i;
        }
        for(int i=0;i<=str[longestIndex].length()-1;i++){
            for(int j = 0;j<=str.length-1;j++) {
                if(i<str[j].length())
                    System.out.print(str[j].charAt(i) + "\t");
                else
                    System.out.print(" \t");
            }
            System.out.println();
        }
    }
}