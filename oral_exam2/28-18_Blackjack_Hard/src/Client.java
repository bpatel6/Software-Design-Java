import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;


public class Client extends JFrame implements ActionListener{

    private Scanner input;
    private Formatter output;
    private String address;
    private Socket connection;
    private JTextArea displayArea;
    private JTextField inputArea;
    private int helper;

    Client(String address)
    {
        super("Player");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        inputArea = new JTextField();
        inputArea.addActionListener(this);
        add(inputArea, BorderLayout.SOUTH);
        setSize(300,300);
        setVisible(true);
        this.address = address;
    }

    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        displayArea.append(messageToDisplay + "\n");
                    }
                }
        );
    }


    public void startClient()
    {
        try {
            connection = new Socket(InetAddress.getByName(address), 23511);
            output = new Formatter(connection.getOutputStream());
            output.flush();
            input = new Scanner(connection.getInputStream());
            displayMessage("Connected to Dealer Server!!");
            startGame();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            displayMessage("Closing connection to server");
            closeConnection();
        }
    }


    private void startGame()
    {
        output.format("Play\n");
        output.flush();
        while(true)
        {
            if (input.hasNextLine())
            {
                processMessage(input.nextLine());
            }
        }
    }

    private void closeConnection() {
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
            inputArea.setEditable(false);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    private void processMessage(String message)
    {
        if(message.contains("Draws:"))
        {
            message = message.replace("Draws: ", "");
            displayMessage("Player: " + message);
            displayMessage("0: Hit, 1: Stay");
            displayMessage("Enter your choice: ");
            helper = 0;
        }
        if(message.contains("Server:"))
        {
            message = message.replace("Server: ", "");
            displayMessage(message);
        }
        if(message.contains("Winner:"))
        {
            //message = message.replace("W/L: ", "");
            displayMessage(message);
            displayMessage("Play again?");
            displayMessage("0: Yes, 1: No");
            displayMessage("Enter your choice:");
            helper = 1;
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int choice = Integer.parseInt(actionEvent.getActionCommand());
        if (choice == 0 && helper == 0){
            output.format("Hit\n");
            output.flush();
            inputArea.setText("");
        }
        else if(choice == 1 && helper == 0){
            output.format("Stay\n");
            output.flush();
            inputArea.setText("");
        }
        else if(choice == 0 && helper == 1){
            output.format("Play\n");
            output.flush();
            inputArea.setText("");
        }
        else if (choice == 1 && helper == 1){
            output.format("Quit\n");
            output.flush();
            inputArea.setText("");
            closeConnection();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid input");
            inputArea.setText("");
        }
    }
}
