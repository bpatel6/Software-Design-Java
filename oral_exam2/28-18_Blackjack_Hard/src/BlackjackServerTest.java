import javax.swing.*;

/**
 * The class to run server
 * @see BlackjackServerTest
 */
public class BlackjackServerTest {
    public static void main(String[] args) {
        BlackjackServer application = new BlackjackServer();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.execute();
    }
}
