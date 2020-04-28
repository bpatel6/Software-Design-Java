import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {
    private String address;
    private Socket connection;

    public Client(String host) {
        this.address = host;
    }

    public void runClient(){
        try{
            connectToServer();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    private void connectToServer() throws IOException{
        connection = new Socket(InetAddress.getByName(address),23511);
    }

    private void closeConnection(){
        try {
            connection.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
