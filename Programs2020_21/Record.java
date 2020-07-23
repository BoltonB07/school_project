package Programs2020_21;

import java.util.Scanner;

public class Record {
    String[] name;
    int[] rank;

    Record(String[] name$, int[] rank$) {
        Scanner sc = new Scanner(System.in);
        name = name$;
        rank = rank$;
    }

    public Record() {

    }

    void readValues() { //to take input
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            System.out.println("Enter name " + i);
            name[i] = sc.nextLine();
            System.out.println("Enter rank " + i);
            rank[i] = sc.nextInt();
        }
    }

    void display() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name[i] + "\t" + rank[i]);
        }
    }

    public static void main(String[] args) {

    }

    class Rank { //COPPER V to CHAMPION
        int index;
    }
}
