package Journal_Programs;

import java.util.Scanner;

public class Diagonal {
    int[][] input;

    Diagonal(int[][] input$) {
        input = input$;
    }

    void printDiagonal() {
        mainloop:
        for (int i = 0; i <= input.length - 1; ) {
            if (i < input.length - 2) {
                i++;
            }
            subloop:
            for (int j = 0; (j + 1) > input[i].length - 1; ) {
                System.out.print(input[i][j]);
                if (i - 1 < 0 || i - 1 > input.length - 1) {
                    break subloop;
                }
                i--;
                j++;
            }
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