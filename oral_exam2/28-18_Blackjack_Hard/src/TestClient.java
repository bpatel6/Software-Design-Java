import javax.swing.*;

public class TestClient {
    public static void main(String[] args) {
        Client application;
        if (args.length == 0){
            application = new Client("127.0.0.1");
            application.startClient();
        }
        else{
            application = new Client(args[0]);
        }
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
