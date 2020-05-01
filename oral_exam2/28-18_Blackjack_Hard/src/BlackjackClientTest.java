import javax.swing.*;

public class BlackjackClientTest {
    public static void main(String[] args) {
        BlackjackClient application;
        if (args.length == 0){
            application = new BlackjackClient("127.0.0.1");
            application.startClient();
        }
        else{
            application = new BlackjackClient(args[0]);
        }
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
