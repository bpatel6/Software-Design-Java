import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The class to represent GuessNumber JFrame and Implementation of the logic
 *
 * @see GuessNumber
 */

public class GuessNumber extends JFrame {
    /**
     * random_n to store the random integer generated
     */
    private int random_n;
    /**
     * label1 and label2 to display JLabel text on the JFrame
     */
    private final JLabel label1, label2;
    /**
     * text1 to display JTextField on the JFrame
     */
    private final JTextField text1;
    /**
     * button1 to display JButton on the JFrame
     */
    private final JButton button1;

    /**
     * Gets the random_n instance variable value
     * @return the random_n value
     */
    public int getRandom_n() {
        return random_n;
    }

    /**
     * Sets the random_n instance variable value
     * @param random_n integer to set set it to random_n
     */
    public void setRandom_n(int random_n) {
        this.random_n = random_n;
    }

    /**
     * GuessNumber() constructor create an object of a GuessNumber
     * Sets the JFrame, JLabel, JTextField and JButton
     */
    public GuessNumber() {
        super("GuessNumber");
        super.getContentPane().setBackground(Color.cyan);
        random_n = 0;
        setLayout(null);
        label1 = new JLabel("GUESS A NUMBER BETWEEN 1-1000");
        label2 = new JLabel("Press Start!");
        text1 = new JTextField("GUESS YOUR 1ST NUMBER");
        text1.setEditable(false);
        button1 = new JButton("START");
        button1.setBackground(Color.white);
        add(label1);
        add(label2);
        add(text1);
        add(button1);
        //Sets the location of the each field in the JFrame
        label1.setBounds(50, 35, label1.getPreferredSize().width, label1.getPreferredSize().height);
        label2.setBounds(120, 130, label2.getPreferredSize().width, label2.getPreferredSize().height);
        text1.setBounds(70, 55, text1.getPreferredSize().width, text1.getPreferredSize().height);
        button1.setBounds(110, 0, button1.getPreferredSize().width, button1.getPreferredSize().height);

        GuessNumberHandler handler = new GuessNumberHandler();
        text1.addActionListener(handler);
        button1.addActionListener(handler);
    }

    /**
     * The class to handle the events of GuessNumber class
     * @see GuessNumberHandler
     * GuessNumberHandler also implements the ActionListener
     */
    private class GuessNumberHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent Event) {
            int i;
            // Implements the button1
            // If button is pressed then generate a random int between 0-1000 and sets it to var. random_n
            if (Event.getSource() == button1) {
                Random rand = new Random();
                random_n = rand.nextInt(1000);
                text1.setEditable(true);
                label2.setText("Good Luck!");
                button1.setEnabled(false);
                System.out.println(random_n);
            }

            // Get the input value from field text1 and then compares it to var. random_n
            // Display the message and changes color of JFrame background accordingly
            if (Event.getSource() == text1) {
                i = Integer.parseInt(Event.getActionCommand());
                if (i > 1000 || i < 0) {
                    JOptionPane.showMessageDialog(null, "Enter number between 1-1000");
                } else if (getRandom_n() == i) {
                    label2.setText("Correct!");
                    getContentPane().setBackground(Color.white);
                    text1.setEditable(false);
                    button1.setEnabled(true);
                } else if ((Math.abs(getRandom_n() - i) <= 50)) {
                    label2.setText("Very Close!");
                    getContentPane().setBackground(Color.green);
                } else if ((Math.abs(getRandom_n() - i) <= 100)) {
                    label2.setText("Close!!!");
                    getContentPane().setBackground(Color.yellow);
                } else if (i < getRandom_n()) {
                    label2.setText("Too Low");
                    getContentPane().setBackground(Color.red);
                } else if (i > getRandom_n()) {
                    label2.setText("Too High");
                    getContentPane().setBackground(Color.blue);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
            }
        }
    }
}
