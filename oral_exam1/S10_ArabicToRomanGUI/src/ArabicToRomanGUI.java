import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import static java.lang.Integer.parseInt;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/


public class ArabicToRomanGUI extends JFrame{
    private final JTextField text1;
    private final JTextField text2;
    private final JLabel label1, label2, label3;
    private static final char [] keys = {'1','2','3','4','5','6','7','8','9','0'};
    private static final char [] roman = {'I','V','X','L','C','D','M'};

    public ArabicToRomanGUI(){
        super("ArabictoRoman");
        super.getContentPane().setBackground(Color.cyan);
        setLayout(null);
        text1 = new JTextField(15);;
        text2 = new JTextField(15);
        label1 = new JLabel("ARABIC OR ROMAN CONVERTER");
        label2 = new JLabel("Arabic-#");
        label3 = new JLabel("Roman-#");
        add(text1);
        add(text2);
        add(label1);
        add(label2);
        add(label3);
        label1.setBounds(55,110, label1.getPreferredSize().width, label1.getPreferredSize().height);
        text1.setBounds(85,130, text1.getPreferredSize().width,text1.getPreferredSize().height);
        text2.setBounds(85, 150, text2.getPreferredSize().width, text2.getPreferredSize().height);
        label2.setBounds(35,130,label2.getPreferredSize().width,label2.getPreferredSize().height);
        label3.setBounds(35,150,label3.getPreferredSize().width,label3.getPreferredSize().height);

        keypressing key = new keypressing();
        text1.addKeyListener(key);
        text2.addKeyListener(key);
    }

    private class keypressing implements KeyListener {
        char i = 0;
        StringBuilder s = new StringBuilder();
        StringBuilder r = new StringBuilder();
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getSource() == text1) {
                s = new StringBuilder();
                s.append(text1.getText());
                if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (s.length() > 0) {
                        s.deleteCharAt(s.length() - 1);
                        if (s.length() == 0){
                            text2.setText("");
                        }
                        else {
                            text2.setText(arabictoroman(parseInt(String.valueOf(s))));
                        }
                    }
                } else if (checkkeynumber(keyEvent.getKeyChar())) {
                    s.append(keyEvent.getKeyChar());
                    if(Integer.parseInt(String.valueOf(s))>3999){
                        JOptionPane.showMessageDialog(null,"Number must be between 1-3999");
                        text1.setText("");
                        text2.setText("");
                    }
                    else {
                        text2.setText(arabictoroman(parseInt(String.valueOf(s))));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Enter # between 0-9");
                    text1.setText("");
                    text2.setText("");
                }
            }
            else if (keyEvent.getSource() == text2){
                s = new StringBuilder();
                s.append(text2.getText());
                if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (s.length() > 0) {
                        s.deleteCharAt(s.length() - 1);
                        if (s.length() == 0){
                            text1.setText("");
                        }
                        else {
                            text1.setText(romantoarabic(s.toString()));
                        }
                    }
                } else if(checkkeyroman(keyEvent.getKeyChar())){
                    s.append(keyEvent.getKeyChar());
                    text1.setText(romantoarabic(s.toString()));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Input. Enter ROMAN Alphabets only");
                    text2.setText("");
                    text1.setText("");
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }

   public String arabictoroman(int i){
       StringBuilder output1 = new StringBuilder();
           while (i != 0) {
               if (i >= 1000) {
                   output1.append('M');
                   i -= 1000;
               } else if (i >= 500) {
                   if (i < 900) {
                       output1.append('D');
                       i -= 500;
                   } else {
                       output1.append("CM");
                       i -= 900;
                   }
               } else if (i >= 100) {
                   if (i < 400) {
                       output1.append('C');
                       i -= 100;
                   } else {
                       output1.append("CD");
                       i -= 400;
                   }
               } else if (i >= 50) {
                   if (i < 90) {
                       output1.append('L');
                       i -= 50;
                   } else {
                       output1.append("XC");
                       i -= 90;
                   }
               } else if (i >= 10) {
                   if (i < 40) {
                       output1.append('X');
                       i -= 10;
                   } else {
                       output1.append("XL");
                       i -= 40;
                   }
               } else if (i >= 5) {
                   if (i < 9) {
                       output1.append('V');
                       i -= 5;
                   } else {
                       output1.append("IX");
                       i -= 9;
                   }
               } else {
                   if (i < 4) {
                       output1.append('I');
                       i -= 1;
                   } else {
                       output1.append("IV");
                       i -= 4;
                   }
               }
           }
       return String.valueOf(output1);
   }

   public String romantoarabic(String input){
       int number = 0;
       for (int i = 0; i < input.length(); i++){
           if (i+1 < input.length()){
               if (value(input.charAt(i)) >= value(input.charAt(i+1))){
                   number += value(input.charAt(i));
               }
               else {
                   number += value(input.charAt(i+1)) - value(input.charAt(i));
                   i++;
               }
           }
           else {
               number += value(input.charAt(i));
           }
       }
       return String.valueOf(number);
   }

    public int value(char n){
        int i = 0;
        if (n == 'M'){
            i = 1000;
        }
        else if (n == 'D'){
            i = 500;
        }
        else if (n == 'C'){
            i = 100;
        }
        else if (n == 'L'){
            i = 50;
        }
        else if (n == 'X'){
            i = 10;
        }
        else if (n == 'V'){
            i = 5;
        }
        else if (n == 'I'){
            i = 1;
        }
        return i;
    }

    public boolean checkkeynumber(char input){
        for (int i = 0; i < keys.length; i++){
            if (input == keys[i]){
                return true;
            }
        }
        return false;
    }

    public boolean checkkeyroman(char input){
        for (int i = 0; i < roman.length; i++){
            if (input == roman[i]){
                return true;
            }
        }
        return false;
    }
}
