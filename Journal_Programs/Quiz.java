package Journal_Programs;

import java.util.Scanner;

public class Quiz {
    char[][] arr;
    char[] key;
    int[] score;
    Quiz(char[] key, char[][] arr,int[] score){
        this.arr=arr;
        this.key=key;
        this.score=score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many participants?");
        int n=sc.nextInt();
        char[][] arr = new char[n][5];
        char[] key = new char[5];
        System.out.println("Enter answer key");
        for (int i = 0; i < 5; i++)
            key[i] = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the participants' answers");
        for(int i = 0; i<n;i++){
            System.out.println("Participant "+(i+1)+":");
            for(int j = 0;j<5;j++)
                arr[i][j]=sc.next().toUpperCase().charAt(0);
        }
        int[] score = new int[n];
        for(int i = 0;i<n;i++)
            score[i] = 0;
        Quiz o = new Quiz(key,arr,score);
        o.check();
        o.display();
    }

    void check(){
        for(int i = 0; i <= arr.length-1;i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j]==key[j])
                    score[i]++;
            }
        }
    }
    void display(){
        int highscore=0;
        for(int i=0;i<=arr.length-1;i++){
            System.out.println("Participant "+(i+1)+"="+score[i]);
            if(score[i]>highscore)
                highscore=score[i];
        }
        System.out.print("Highest score: ");
        for(int i =0;i<score.length;i++){
            if(score[i]==highscore)
                System.out.println("Participant "+(i+1));
        }
    }
}