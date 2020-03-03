import javax.swing.*;

public class GuessNumberTest {
    public static void main(String[] args) {
        GuessNumber guessnumber = new GuessNumber();
        guessnumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessnumber.setResizable(false);
        guessnumber.setSize(300, 300);
        guessnumber.setVisible(true);
    }
}
