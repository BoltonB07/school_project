package Journal_Programs;

import java.util.Scanner;

public class Diagonal {
    int[][] input;

    Diagonal(int[][] input$) {
        input = input$;
    }

    void printDiagonal() {      //main logic method
        int counter=0;
        mainloop:
        for (int i = 0; i <= input.length - 1; ) {
            if(counter>=8){break mainloop;}
            System.out.println();
            subloop:
            for (int j = 0; ; ) {
                if(counter>4){j=counter-i;}
                System.out.print(input[i][j]+"\t");
                if (i - 1 < 0 || j + 1 > input[i].length - 1) {
                    break subloop;
                }
                i--;
                j++;
            }
            counter++;
            if (counter<=4) {
                i=counter;
            }
            else{i=4;}

        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array");
        int[][] inputx= new int[5][4];
        for(int i=0;i<=inputx.length-1;i++){
            for(int j=0;j<=inputx[i].length-1;j++){
                inputx[i][j]=sc.nextInt();
            }
        }
        Diagonal o = new Diagonal(inputx);
        o.printDiagonal();
    }
}