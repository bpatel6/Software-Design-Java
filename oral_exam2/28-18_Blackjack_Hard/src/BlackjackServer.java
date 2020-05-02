import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The class to run server and to run game
 * @see BlackjackServer
 */
public class BlackjackServer extends JFrame {
    private ServerSocket server;
    private ExecutorService service;
    private Player[] players;
    private JTextArea displayArea;

    /**
     * Blackjack server constructor to start the server and setup GUI
     */
    public BlackjackServer() {
        super("Dealer");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(Color.CYAN);
        displayArea.setText("Welcome to Blackjack!!\nWaiting for Player!!");
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);
        service = Executors.newFixedThreadPool(4);
        players = new Player[4];
        // Setup the server
        try {
            server = new ServerSocket(23511, 4);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * Method to display the message to the GUI JTextArea
     * @param messageToDisplay message to display in GUI
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
     * Method to initiate connection with players
     */
    public void execute() {
        for (int i = 0; i < 4; i++) {
            try {
                players[i] = new Player(server.accept());
                displayMessage("\nPlayer Connected!!");
                service.execute(players[i]);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
    }


    /**
     * The class to play game with the individual players
     * @see Player
     */
    private class Player implements Runnable {
        private Socket connection;
        private Formatter output;
        private Scanner input;

        /**
         * The player class constructor setups the output and input streams for player
         * @param socket player socket
         */
        public Player(Socket socket) {
            connection = socket;
            try {
                output = new Formatter(connection.getOutputStream());
                input = new Scanner(connection.getInputStream());

            } catch (IOException ioException) {

                ioException.printStackTrace();
                System.exit(1);
            }
        }

        /**
         * Method to close out connection with client
         */
        public void closeConnection() {
            try {
                output.close();
                input.close();
                connection.close();
                displayMessage("Connection closed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Method to run the game and to interact with player
         */
        public void run() {
            String inputMessage;
            boolean playerDisconnects = false;
            Deck deck = new Deck();
            int playerTotal = 0;
            int dealerTotal = 0;
            Card card;

            // keep running the game until there is an input from player
            while (input.hasNextLine()) {
                inputMessage = input.nextLine();

                // if player decide to quit the game
                if (inputMessage.contains("Quit")) {
                    playerDisconnects = true;
                    closeConnection();
                } else if (!playerDisconnects) {

                    // If player want to stay, check the total and announce winner
                    if (inputMessage.contains("Stay")) {
                        while (dealerTotal < 16) {
                            card = deck.getCard();
                            dealerTotal += card.getValue();
                        }

                        if (dealerTotal > playerTotal && dealerTotal <= 21) {
                            displayMessage("Dealer Wins!! Dealer: " + dealerTotal + " Player: " + playerTotal);
                            output.format("Winner: Dealer Wins!! Dealer: " + dealerTotal + " Player: " + playerTotal + "\n");
                            output.flush();
                        } else if (dealerTotal > 21) {
                            displayMessage("Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal);
                            output.format("Winner: Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal + "\n");
                            output.flush();
                        } else if (dealerTotal == playerTotal) {
                            displayMessage("Game Tied!! Player: " + playerTotal + " Dealer " + dealerTotal);
                            output.format("Winner: Game Tied!! Player: " + playerTotal + " Dealer " + dealerTotal + "\n");
                            output.flush();
                        } else {
                            displayMessage("Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal);
                            output.format("Winner: Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal + "\n");
                            output.flush();
                        }
                    }

                    // If player wants to draw another card
                    else if (inputMessage.contains("Hit")) {
                        if (playerTotal < 21) {
                            card = deck.getCard();
                            playerTotal += card.getValue();
                            displayMessage("Player: " + card.toString());
                            output.format("Draws: " + card.toString() + "\n");
                            output.flush();
                        }
                        if (playerTotal > 21) {
                            displayMessage("Player busted! Dealer wins!\nDealer: " + dealerTotal + " Player: " + playerTotal);
                            output.format("Winner: Player busted! Dealer wins! Dealer: " + dealerTotal + " Player: " + playerTotal + "\n");
                            output.flush();
                        }
                    }
                    // If no input requires, it's the beginning of the game, so draw card for dealer and player
                    else {
                        playerTotal = 0;
                        dealerTotal = 0;
                        deck.shuffle();
                        card = deck.getCard();
                        playerTotal += card.getValue();
                        displayMessage("Player: " + card.toString());
                        output.format("Server: Player: " + card.toString() + "\n");
                        output.flush();

                        card = deck.getCard();
                        dealerTotal += card.getValue();
                        displayMessage("Dealer: " + card.toString());
                        output.format("Server: Dealer: " + card.toString() + "\n");
                        output.flush();

                        card = deck.getCard();
                        playerTotal += card.getValue();
                        displayMessage("Player: " + card.toString());
                        output.format("Draws: " + card.toString() + "\n");
                        output.flush();

                        card = deck.getCard();
                        dealerTotal += card.getValue();

                    }
                } else {
                    // Nothing runs or break close the connection
                    closeConnection();
                    break;
                }
            }
        }
    }
}


