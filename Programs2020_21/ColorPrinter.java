package Programs2020_21;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Color;

class ColorPrinter {

    private JScrollPane scrollPane;
    private StyledDocument doc;
    private Style style;

    ColorPrinter() {
        JTextPane textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane);
        textPane.setEditable(false);
        doc = textPane.getStyledDocument();
        style = doc.addStyle("", null);
    }

    //Example demonstrating its use
    public static void main(String[] args) {
        ColorPrinter printer = new ColorPrinter();
        printer.println("HAI I AM A CHICKEN EATING DINO");
        printer.setBackground(Color.BLUE);
        printer.println("NICE COLOR");
        printer.setForeground(Color.RED);
        printer.println("WOOW");
        printer.setForeground(Color.GREEN);
        printer.setBackground(Color.GRAY);
        printer.println("SO COOOL");
        printer.finish();
    }

    void setForeground(Color color) {
        StyleConstants.setForeground(style, color);
    }

    void setBackground(Color color) {
        StyleConstants.setBackground(style, color);
    }

    void print(Object o) {
        try {
            doc.insertString(doc.getLength(), o.toString(), style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    void println(Object o) {
        print(o + "\n");
    }

    /**
     * Displays all the text
     * <p>
     * This should be called only after everything is printed. Once this is called, calls to print and println will
     * not update the screen.
     */
    void finish() {
        //Executes the following code in the event dispatching thread rather than the main thread
        //I don't know what that means either but it fixes the problem
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(scrollPane);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /**
     * @param width the width of the JFrame
     * @param height the height of the JFrame
     */
    void finish(int width, int height) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(width, height);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(scrollPane);
                frame.setVisible(true);
            }
        });
    }
}
