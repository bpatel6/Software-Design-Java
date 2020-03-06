import javax.swing.*;

/**
 * The class to runs and test the ArabicToRomanGUI() implementation
 * @see ArabicToRomanGUI_Test
 */

public class ArabicToRomanGUI_Test {
    public static void main(String[] args) {
        ArabicToRomanGUI arabictoromangui = new ArabicToRomanGUI();
        arabictoromangui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arabictoromangui.setResizable(false);
        arabictoromangui.setSize(300, 300);
        arabictoromangui.setVisible(true);
    }
}
