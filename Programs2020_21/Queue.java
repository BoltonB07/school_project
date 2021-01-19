package Programs2020_21;

import java.util.Scanner;

public class Queue {
    int queueSize=5;
    int[] arr = new int[queueSize];
    int front=0;
    void enQueue(int n){
        if(front<queueSize){
            arr[front]=n;
            front++;
            System.out.println("Enqueue successful");
        }
        else
            System.out.println("Queue Error 001: Queue full!");
    }
    int deQueue(){
        if(front!=0) {
            int rearValue = arr[0];
            shiftBack();
            front--;
            System.out.println("Dequeue successful");
            return rearValue;
        }
        else {
            System.out.println("Queue Error 002: Queue empty!");
            return -999;
        }
    }
    void show(){
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+((i==arr.length-1)?".":", "));

        }
    }
    void shiftBack(){
        for(int i=1;i<=arr.length-1;i++){
            arr[i-1]=arr[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int input;
        Queue obj=new Queue();
        //boolean hasChangedSize=false;
        do{
            //System.out.println(hasChangedSize?"1) Set Queue Size (Currently set to "+queueSize+" manually)":"1) Set Queue Size (5 by default)");
            System.out.println("1) Enqueue\n2) Dequeue\n3) Show Queue\n4) Exit");
            input=sc.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("Enter a number to be enqueued");
                    int newElement = sc.nextInt();
                    obj.enQueue(newElement);
                }
                case 2 -> {
                    int dequeueValue=obj.deQueue();
                    System.out.println(dequeueValue != -999 ? dequeueValue+" has been Dequeued" : "");

                }
                case 3 -> {
                    obj.show();
                    System.out.println();
                }
            }
        }
        while(input!=4);
        System.exit(0);
    }
}
