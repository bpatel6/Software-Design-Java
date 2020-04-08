import javax.swing.*;

/**
 * The class to runs and test the RandomCircle implementation
 * @see RandomCircleTest
 */

public class RandomCircleTest {
    public static void main(String[] args) {
        RandomCircle randomCircle = new RandomCircle();
        randomCircle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        randomCircle.setResizable(false);
        randomCircle.setSize(350, 350);
        randomCircle.setVisible(true);
    }
}
