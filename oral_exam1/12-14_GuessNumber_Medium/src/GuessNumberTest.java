import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuessNumberTest {
    public static void main(String args[]){
        GuessNumber guessnumber = new GuessNumber();
        guessnumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessnumber.setSize(300, 300);
        guessnumber.setVisible(true);
    }
}
