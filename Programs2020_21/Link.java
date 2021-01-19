package Programs2020_21;

import java.util.Scanner;

public class Link {
    int[] lnk;
    int max, begin, end;

    Link(int mm) {
        max = mm;
        begin = 0;
        end = 0;
        lnk = new int[max];
    }

    public static void main(String[] args) {
        Link obj = new Link(100);
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add to Queue\n2. Remove and display newest element in Queue\n3. Show Queue\n4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter number to be added to Queue:");
                    obj.addLink(sc.nextInt());
                }
                case 2 -> {
                    System.out.println(obj.delink());
                }
                case 3 -> obj.display();
            }
        } while (choice != 4);
    }

    void addLink(int v) {
        if (begin != lnk.length - 1) {    //Shifting ahead the elements so that we have space for the new element.
            for (int i = begin; i >= 0; i--) {
                lnk[i + 1] = lnk[i];
            }
            begin++;
            lnk[0] = v;
        } else
            System.out.println("OUT OF SIZE..."); //Error message
    }

    int delink() { //This method is for only returning the frontmost element in queue.
        if (begin > 0) {
            return lnk[--begin];
        } else {
            System.out.println("EMPTY...");
            return -99;
        }
    }

    void display() { //Display method
        for (int i = 0; i < begin; i++) {
            System.out.print(lnk[i] + ((i + 1 < begin) ? ", " : "."));
        }
        System.out.println();
    }
}
