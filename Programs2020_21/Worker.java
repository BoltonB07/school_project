package Programs2020_21;

public class Worker { String name; Float basic;
    Worker(String name$, float basic$){
        name=name$;
        basic=basic$;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Basic pay: "+basic);
    }
}
class Wages extends Worker{
    int hrs; float rate, wage;
    Wages(String name$, float basic$, int hrs$, float rate$, float wage$){
        super(name$, basic$);
        hrs=hrs$;
        rate=rate$;
        wage=wage$;
    }
    double overtime(){
        return hrs*rate;
    }
    void display(){
        wage= (float) (overtime()+basic);
        super.display();
        System.out.println("Hours: "+hrs);
        System.out.println("rate: "+rate);
        System.out.println("wage: "+wage);
    }
}
