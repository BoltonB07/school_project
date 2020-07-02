package Programs2020_21;

import java.util.Scanner;

public class Detail {
    String name, address;long telno;float rent;
    Detail(String name$, String address$, long telno$, float rent$){
        name=name$;
        address=address$;
        telno=telno$;
        rent=rent$;
    }

    public Detail() {

    }

    void show(){
        System.out.print("Customer details:\n"+"Name: "+name+"\nAddress:"+address+"\nTelephone: "+telno+"\nRent:"+rent);
    }

    public static void main(String[] args) {
        System.out.println("We will need you to enter the following details:");
        String name$; String address$; long telno$; float rent$;
        System.out.println("Enter name below:");
        Scanner sc=new Scanner(System.in);
        name$=sc.nextLine();
        System.out.println("Enter Address below:");
        address$=sc.nextLine();
        System.out.println("Enter Telephone Number below:");
        telno$=sc.nextLong();
        System.out.println("Enter your monthly Rent below:");
        rent$=sc.nextFloat();
        Detail obj=new Detail(name$,address$,telno$,rent$);
        obj.show();
    }
}

class Bill extends Detail {
    int n;
    float amt;

    Bill(String name$, String address$, long telno$, float rent$) {
        super(name$, address$, telno$, rent$);
        amt = 0.0f;
    }

    void cal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of calls");
        n = sc.nextInt();
        if (n <= 100) {
            amt = rent;
        } //QUESTION: Why cannot I put "rent$" and why does it take "rent?
        else if (n >= 101 && n <= 200) {
            amt = (float) ((0.60 * n) + rent);
        } else if (n >= 201 && n <= 300) {
            amt = (float) ((0.80 * n) + rent);
        } else {
            amt = (float) (n + rent);
        }
    }

    void show() {
        Detail obj = new Detail();
        obj.show();
        System.out.println("Final Amount payable: $" + amt);
    }

    public static void main(String[] args) {

    }
}
