package Programs2020_21;

import java.util.Scanner;

public class Array_to_Stack {
    int[] m=new int[50]; //As 50 is mentioned in the QP
    int[] st=new int[50];
    int cap;
    int top;//initializing values
    Array_to_Stack(int n){
        cap=n;
        top=-1;
    }
    void input_marks(){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<=cap-1;i++){
            m[i]=sc.nextInt();
            //pushing into stack
            pushmarks(m[i]);
        }
    }
    void pushmarks(int v){
        if(top==49) //As the limit is 50 as per the question
            System.out.println("Not possible as stacDk is full");
        else{
            st[top+1]=v;
        }
    }
    int popmarks(){
        if(top==-1)
            return -999;
        else{
            top--; //the stack height reduces by 1
            return st[top+1]; //top+1 because top was reduced before
        }
    }
    void display(){
        for(int i=0;i<=top;i++){
            System.out.println(st[i]+", ");
        }
    }
}
