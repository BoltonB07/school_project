package Programs2020_21;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

class ColorPrinter {

    private JFrame frame;
    private JTextPane pane;
    private StyledDocument doc;
    private Style style;

    ColorPrinter() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JTextPane();
        pane.setEditable(false);
        doc = pane.getStyledDocument();
        style = doc.addStyle("", null);
    }

    /**
     * @param width the width of the screen
     * @param height the height of the screen
     */
    ColorPrinter(int width, int height) {
        this();
        frame.setSize(width, height);
    }

    //Example demonstrating its use
    public static void main(String[] args) {
        ColorPrinter printer = new ColorPrinter(640, 640);
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

    void print(String s) {
        try {
            doc.insertString(doc.getLength(), s, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    void println(String s) {
        print(s + "\n");
    }

    /**
     * Displays all the text
     * <p>
     * This should be called only after everything is printed. Once this is called, calls to print and println will
     * not update the screen
     */
    void finish() {
        frame.add(pane);
        frame.setVisible(true);
    }
}
