import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BlackjackServer extends JFrame {
    private ServerSocket server;
    private ExecutorService service;
    private Player[] players;
    private JTextArea displayArea;

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
        try {
            server = new ServerSocket(23511, 4);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }

    }

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


    private class Player implements Runnable {
        private Socket connection;
        private Formatter output;
        private Scanner inputString;

        public Player(Socket socket) {
            connection = socket;
            try {
                output = new Formatter(connection.getOutputStream());
                inputString = new Scanner(connection.getInputStream());

            } catch (IOException ioException) {

                ioException.printStackTrace();
                System.exit(1);
            }
        }

        public void closeConnection() {
            try {
                output.close();
                inputString.close();
                connection.close();
                displayMessage("Connection closed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String inputMessage;
            boolean playerDisconnects = false;
            Deck deck = new Deck();
            int playerTotal = 0;
            int dealerTotal = 0;
            Card card;

            while (inputString.hasNextLine()) {
                inputMessage = inputString.nextLine();

                if (inputMessage.contains("Quit")) {
                    playerDisconnects = true;
                    closeConnection();
                } else if (!playerDisconnects) {

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
                    closeConnection();
                    break;
                }
            }
        }
    }
}


