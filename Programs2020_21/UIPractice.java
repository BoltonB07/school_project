package Programs2020_21;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class UIPractice {

}
class window extends JFrame{
    JTextField item1;
    JTextField item2;
    JTextField item3;
    JPasswordField passwordField;
    window(){
        super("ERV Aviation bvba.");
        setLayout(new FlowLayout());
        item1=new JTextField(10);
        add(item1);
        item2=new JTextField("Enter Text hier"); //CommentLine1
        add(item2);
        item3=new JTextField("Uneditable");
        item3.setEditable(false);
        add(item3);
        passwordField=new JPasswordField("1234");
        add(passwordField);
        //continue from thenewboston's java beginner tutorial part 53.
    }
}
