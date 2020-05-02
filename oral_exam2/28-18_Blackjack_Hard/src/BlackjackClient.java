import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

/**
 * The class to represent the Blackjack client/player
 * @see BlackjackClient
 */
public class BlackjackClient extends JFrame implements ActionListener {

    private Scanner input;
    private Formatter output;
    private String address;
    private Socket connection;
    private JTextArea displayArea;
    private JTextField inputArea;
    private int helper;

    /**
     * Constructor to initiate client GUI and client
     * @param address
     */
    BlackjackClient(String address) {
        super("Player");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(Color.CYAN);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        inputArea = new JTextField();
        inputArea.setBackground(Color.lightGray);
        inputArea.addActionListener(this);
        add(inputArea, BorderLayout.SOUTH);
        setSize(300, 300);
        setVisible(true);
        this.address = address;
    }

    /**
     * Method to add message to the display JTextArea
     * @param messageToDisplay
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        displayArea.append(messageToDisplay + "\n");
                    }
                }
        );
    }


    /**
     * Method to setup the socket, input & output streams and invokes the game
     */
    public void startClient() {
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
            displayMessage("Closing connection to Dealer");
            closeConnection();
        }
    }

    /**
     * Method to start the game and continuously runs until no input stream available
     */
    private void startGame() {
        output.format("Play\n");
        output.flush();
        while (input.hasNextLine()) {
            processMessage(input.nextLine());
        }

    }

    /**
     * Method to close socket, input & output streams
     */
    private void closeConnection() {
        try {
            output.close();
            input.close();
            connection.close();
            inputArea.setEditable(false);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    /**
     * Method to process a message received from the Dealer server
     * @param message
     */
    private void processMessage(String message) {
        // If player wants to draw a new card from the deck
        if (message.contains("Draws:")) {
            message = message.replace("Draws: ", "");
            displayMessage("Player: " + message);
            displayMessage("0: Hit, 1: Stay");
            displayMessage("Enter your choice: ");
            helper = 0;
        }
        // If the game is over display the winner and the score
        else if (message.contains("Winner:")) {
            displayMessage(message);
            displayMessage("Play again?");
            displayMessage("0: Yes, 1: No");
            displayMessage("Enter your choice:");
            helper = 1;
        }

        // If the message sent from the server doesn't require any input from player
        else if (message.contains("Server:")) {
            message = message.replace("Server: ", "");
            displayMessage(message);
        }

        // If no message close connection
        else {
            closeConnection();
        }
    }


    /**
     * Method to send input from JTextField to the server
     * @param actionEvent input put into the JTextField in GUI
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int choice = Integer.parseInt(actionEvent.getActionCommand());
        if (choice == 0 && helper == 0) {
            output.format("Hit\n");
            output.flush();
            inputArea.setText("");
        } else if (choice == 1 && helper == 0) {
            output.format("Stay\n");
            output.flush();
            inputArea.setText("");
        } else if (choice == 0 && helper == 1) {
            output.format("Play\n");
            output.flush();
            inputArea.setText("");
        } else if (choice == 1 && helper == 1) {
            output.format("Quit\n");
            output.flush();
            inputArea.setText("");
            closeConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input");
            inputArea.setText("");
        }
    }
}
