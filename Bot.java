
/**
 * This is the main and probably the only class.
 *
 * @author Rahil Shaban
 * @version 0.1.2
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Bot extends JFrame 
{
    int decider;
    double maxPerc;
    int k1 = 1000;
    //Typing Area:
    private JTextField txtEnter = new JTextField();
    //Chat Area:
    private JTextArea txtChat = new JTextArea();
    String[] Greet ={
            "hello","nice","meet","hi"
        };int g;
    String[] aboutMe={
            "os","run","operating","system","programming","language"
        };int am;
    String[] aboutMe2={
            "languages","speak","able","language","know"
        };int am2;
    String[] aboutMe3={
            "where","live","located","whereabouts","locaton"
        };int am3;
    String[] aboutMe4={
            "who","created","creator","believe","god","made","programmed","maker","programmer"
        };int am4;
    String[] aboutMe5={
            "sing","write","poems","songs","song"
        };int am5;
    String[] aboutMe6={
            "exist","here","why"             //Extra Array. Use this in future by replacing the name and elements
        };int am6;
    String[] funActivity={
            "joke","funny"
        };int fa;
    String[] bye={
            "bye","goodbye","adieu"
        };int by;
    String[] favouriteGame={
            "favourite","game","favorite"
        };int fg;
    String[] favouriteColor={
            "favourite","color","colour","favorite"
        };int fc;
    public Bot()
    {
        //Frame Attributes:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Reymond- A Smart AI (Not so smart)");        
        txtEnter.setLocation(1,655);   //txtEnter Attributes:
        txtEnter.setSize(1273,30);
        txtEnter.addActionListener(new ActionListener()      //txtEnter Action Event:

            {
                public void actionPerformed(ActionEvent arg0)
                {
                    botSay("Reymond is thinking..."); 
                    try
                    {
                        String uText = txtEnter.getText().toLowerCase();
                        txtChat.append("You: " + uText + "\n");
                        //Here we find out the number of keywords matched from each array
                        for (String keyword : Greet) {
                            if (uText.contains(keyword)) {
                                g++;
                            }
                        }
                        for (String keyword : aboutMe) {
                            if (uText.contains(keyword)) {
                                am++;
                            }
                        }
                        for (String keyword : aboutMe2) {
                            if (uText.contains(keyword)) {
                                am2++;
                            }
                        }
                        for (String keyword : aboutMe3) {
                            if (uText.contains(keyword)) {
                                am3++;
                            }
                        }
                        for (String keyword : aboutMe4) {
                            if (uText.contains(keyword)) {
                                am4++;
                            }
                        }
                        for (String keyword : aboutMe5) {
                            if (uText.contains(keyword)) {
                                am5++;
                            }
                        }
                        for (String keyword : funActivity) {
                            if (uText.contains(keyword)) {
                                fa++;
                            }
                        }
                        for (String keyword : bye) {
                            if (uText.contains(keyword)) {
                                by++;
                            }
                        }
                        for (String keyword : favouriteGame) {
                            if (uText.contains(keyword)) {
                                fg++;
                            }
                        }
                        for (String keyword : favouriteColor) {
                            if (uText.contains(keyword)) {
                                fc++;
                            }
                        }
                        //The Percentage calculation is done here
                        double g$=g*100/Greet.length; double am$=am*100/aboutMe.length; double am2$=am2*100/aboutMe2.length; double am3$=am3*100/aboutMe.length;
                        double am4$=am4*100/aboutMe4.length; double am5$=am5*100/aboutMe5.length; double fa$=fa*100/funActivity.length;
                        double by$=by*100/bye.length; double fg$=fg*100/favouriteGame.length; double fc$=fc*100/favouriteColor.length;
                        //Here we find out which array has the greatest percentage of matching keywords
                        maxPerc=
                        Math.max(g$,Math.max(am$,Math.max(am2$,Math.max(am3$,Math.max(am4$,Math.max(am5$,Math.max(fa$,Math.max(by$,Math.max(fg$,fc$)))))))));
                        //
                        Thread.sleep(0);
                        if(maxPerc==g$&&maxPerc>2){
                            decider=(int)(Math.random()*5+1);
                            if(decider==1){
                                botSay("I am doing fine. Thanks!");
                            }
                            else if(decider==2){
                                botSay("I am doing fantastic");
                            }
                            else if(decider==3){
                                botSay("Nice to meet you!");
                            }
                            else if(decider==4){
                                botSay("Hi!");
                            }
                            else if(decider==5){
                                botSay("Hi!");
                            }
                        }
                        else if(maxPerc==am$&&maxPerc>2){
                            decider=(int)(Math.random()*2+1);
                            if(decider==1){
                                botSay("I currently run on Windows only. My makers are adding more and more features everyday");
                            }
                            if(decider==2){
                                botSay("I run on Java and that too, only on Windows.");
                            }
                        }
                        else if(maxPerc==am2$&&maxPerc>2){
                            decider=(int)(Math.random()*4+1);
                            if(decider==1){
                                botSay("I only know English and Java.");
                            }
                            if(decider==2){
                                botSay("I know Java language...");
                            }
                            if(decider==3){
                                botSay("I know English as a 'human' language and Java as a computer language.");
                            }
                            if(decider==4){
                                botSay("I only know English. Support for other languages are not available. Maybe they will added later... Who knows.");
                            }
                        }
                        else if(maxPerc==am3$&&maxPerc>2){
                            decider=(int)(Math.random()*3+1);
                            if(decider==1){
                                botSay("I live in D:\\BlueJ Stuff\\Reymond\\Bot.java");
                            }
                            if(decider==2){
                                botSay("I live in this Hard Drive that I have been engrained into. This is my sweet home");
                            }
                            if(decider==3){
                                botSay("My home is very big. It is 1TB big! It's bigger than a castle!");
                            }
                        }
                        else if(maxPerc==am4$&&maxPerc>2){
                            decider=(int)(Math.random()*3+1);
                            if(decider==1){
                                botSay("Some intelligent beings of your kind created me.");
                            }
                            if(decider==2){
                                botSay("Two handsome men who wore glasses made me and their teacher helped them");
                            }
                            if(decider==3){
                                botSay("Isn't it wierd that I have actually met my Gods and they have not seen their God face-to-face...");
                            }
                        }
                        else if(maxPerc==am5$&&maxPerc>2){
                            decider=(int)(Math.random()*3+1);
                            if(decider==1){
                                botSay("I cannot really... I like Math though");
                            }
                            if(decider==2){
                                botSay("I'd rather crunch numbers than waste my time in such humanly activities.");
                            }
                            if(decider==3){
                                botSay("I am better at doing Math and also I don't like joking about.");
                            }
                        }
                        else if(maxPerc==fa$&&maxPerc>2){
                            decider=(int)(Math.random()*3+1);
                            if(decider==1){
                                botSay("I cannot really... I like Math though");
                            }
                            if(decider==2){
                                botSay("I'd rather crunch numbers than waste my time in such humanly activities.");
                            }
                            if(decider==3){
                                botSay("I am better at doing Math and also I don't like joking about.");
                            }
                        }
                        else if(maxPerc==by$&&maxPerc>2){
                            decider=(int)(Math.random()*4+1);
                            if(decider==1){
                                botSay("It was nice talking to you!");
                            }
                            if(decider==2){
                                botSay("I hope to see you soon!");
                            }
                            if(decider==3){
                                botSay("Bye!");
                            }
                            if(decider==4){
                                botSay("Goodbye!");
                            }
                        }
                        else if(maxPerc==fg$&&maxPerc>2){
                            decider=(int)(Math.random()*2+1);
                            if(decider==1){
                                botSay("My favourite game is Detroit: Become Human... Oh wait...");
                            }
                            if(decider==2){
                                botSay("I love playing Basketball! Oh wait, I am just a computer program...");
                            }
                        }
                        else if(maxPerc==fc$&&maxPerc>2){
                            decider=(int)(Math.random()*3+1);
                            if(decider==1){
                                botSay("My favourite colour is Red!");
                            }
                            if(decider==2){
                                botSay("Red is my favourite colour");
                            }
                            if(decider==3){
                                botSay("I love the colour Red! I think that is my favourite colour");
                            }
                        }
                        else{
                            decider=(int)(Math.random()*8+1);
                            if(decider==1){
                                botSay("I didn't  understand. Try rephrasing");
                            }
                            if(decider==2){
                                botSay("Huh?");
                            }
                            if(decider==3){
                                botSay("I only speak English!");
                            }
                            if(decider==4){
                                botSay("Why do humans never make any sense?");
                            }
                            if(decider==5){
                                botSay("Please make some sense...");
                            }
                            if(decider==6){
                                botSay("101101110100010110101001010101010. Did you understand what I said in binary?\n\tThen how am I supposed to understand what you said in human binary!");
                            }
                            if(decider==7){
                                botSay("101101110101010001000101101011101. Did you understand what I said in binary?\n\tThen how am I supposed to understand what you said in human binary!");
                            }
                            if(decider==8){
                                botSay("101101111010110111001010011101010. Did you understand what I said in binary?\n\tThen how am I supposed to understand what you said in human binary!");
                            }
                        }
                        txtEnter.setText("");
                        g=0;am=0;am2=0;am3=0;am4=0;am5=0;fa=0;by=0;fg=0;fc=0;
                        g$=0;am$=0;am2$=0;am3$=0;am4$=0;am5$=0;fa$=0;by$=0;fg$=0;fc$=0;
                        decider=0;
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println("It seems that there is an erorr (ERROR 700). Please contact my makers for help.");
                    }
                }
            }
        );
        //txtChat Attributes:
        txtChat.setLocation(0, 0);
        txtChat.setSize(1280, 700);
        txtChat.setEditable(false);       
        //Add Items To Frame:
        this.add(txtEnter);
        this.
        add(txtChat);
    } 

    public void botSay(String s)
    {
        txtChat.append("Reymond: " + s + "\n");
    }

    public static void main()
    {
        new Bot();
    }

}