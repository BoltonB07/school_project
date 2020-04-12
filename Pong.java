 

import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Write a description of class Pong here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pong extends JPanel
{
    JFrame frame;
    float x;
    private Pong(){
        frame=new JFrame();
        frame.add(this);
        frame.setSize(1980,1080);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, 0, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval((int)x,51,50,50);
    }
    
    public static void main(String[] args){
        Pong o=new Pong();
    }
}
class Movement extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
        int k=e.getKeyCode();
        switch(k){
            //Case KeyEvent.VK_W
            
        }
    }
}
