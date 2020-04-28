import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {
    private String address;
    private Socket connection;
    private static int player = 1;
    private JTextArea displayArea;
    private JTextField enterfield;
    private ObjectInputStream input;
    private ObjectOutputStream output;


    public Client(String host) {
        super("Player" + player);
        this.address = host;
        player++;
        enterfield = new JTextField();
        add(enterfield, BorderLayout.SOUTH);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300,150);
        setVisible(true);
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
