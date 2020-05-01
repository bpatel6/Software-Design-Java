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
 * The server class does all calculations for the blackjack game, acts as the dealer, and handles the deck
 */
public class Server extends JFrame {
    private ServerSocket server; // server socket
    private ExecutorService service; //thread pool for all of the users connecting to the server
    private Player[] players; // sets up an array of users.
    private JTextArea displayArea;

    public Server()
    {
        super("Dealer");
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setText("Welcome to Blackjack!!\nWaiting for Player!!");
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300,300);
        setVisible(true);
        service = Executors.newFixedThreadPool(4);
        players = new Player[4];
        try
        {
            server = new ServerSocket(23511, 4);
        } catch (IOException ioException)
        {
            ioException.printStackTrace();
            System.exit(1);
        }

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


    public void execute()
    {
        for (int i = 0; i <4; i++)
        {
            try // wait for connection, create Player, start runnable
            {
                players[i] = new Player(server.accept());
                displayMessage("Player Connected!!\n");
                service.execute(players[i]); // execute user runnable from the user inner class
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }
    }


    private class Player implements Runnable {
        private Socket connection;  //connection to client
        private Formatter output;   //output stream to client
        private Scanner inputString;//input stream from client

        public Player(Socket socket) {
            connection = socket;
            try
            {
                output = new Formatter(connection.getOutputStream());
                inputString = new Scanner(connection.getInputStream());

            } catch (IOException ioException) {

                ioException.printStackTrace();
                System.exit(1);
            }
        }


        public void run() {
            String inputMessage;
            boolean playerDisconnects = false;
            Deck deck = new Deck();
            int playerTotal = 0;
            int dealerTotal = 0;
            boolean game = false;
            Card card;

            while (!playerDisconnects) {
                if (inputString.hasNextLine()) {
                    inputMessage = inputString.nextLine();

                    if (inputMessage.contains("Quit")) { playerDisconnects = true;}

                    if (!playerDisconnects) { //if client is terminating, skip all of this

                        if (inputMessage.contains("Play")) { game = true; }

                        if (game){
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

                            game = false;
                        }

                        if (inputMessage.contains("Hit")) { //checks to see if client is terminating connection
                            if (playerTotal < 21) {
                                card = deck.getCard();
                                playerTotal += card.getValue();
                                displayMessage("Player: " + card.toString());
                                output.format("Draws: " + card.toString() + "\n");
                                output.flush();
                            }
                            if(playerTotal > 21){
                                displayMessage("Player busted! Dealer wins!\nDealer: " + dealerTotal + " Player: " + playerTotal);
                                output.format("Winner: Player busted! Dealer wins! Dealer: " + dealerTotal + " Player: "+ playerTotal + "\n");
                                output.flush();
                            }
                        }
                        else if (inputMessage.contains("Stay")) { //checks to see if client is terminating connection
                            while (dealerTotal < 16){
                                card = deck.getCard();
                                dealerTotal += card.getValue();
                            }

                            if (dealerTotal > playerTotal && dealerTotal <= 21){
                                displayMessage("Dealer Wins!! Dealer: " + dealerTotal + " Player: " + playerTotal);
                                output.format("Winner: Dealer Wins!! Dealer: " + dealerTotal + " Player: " + playerTotal + "\n");
                                output.flush();
                            }
                            else if(dealerTotal > 21) {
                                displayMessage("Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal);
                                output.format("Winner: Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal + "\n");
                                output.flush();
                            }
                            else{
                                displayMessage("Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal);
                                output.format("Winner: Player Wins!! Player: " + playerTotal + " Dealer: " + dealerTotal + "\n");
                                output.flush();
                            }
                        }
                    }
                    else {
                        try {
                            output.close();
                            inputString.close();
                            connection.close();
                            displayMessage("Connection closed");
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

