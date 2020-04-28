import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;


public class Server extends JFrame {
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;


    public Server() {
        super("BlackJack Server");
        enterField = new JTextField();
        enterField.addActionListener(
                new ActionListener() {
                    // send message to client
                    public void actionPerformed(ActionEvent event) {
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.SOUTH);
        displayArea = new JTextArea(); // create displayArea
        displayArea.setEditable(false);
        displayArea.setText("Welcome to BlackJack");
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 300); // set size of window
        setVisible(true); // show window
    }

    public void runServer(){
        try {
            server = new ServerSocket(23511,100);
            }
       catch (IOException e) {
            e.printStackTrace();
        }
    }

}
