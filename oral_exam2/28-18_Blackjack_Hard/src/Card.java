/**
 * The class to represent card face, value and suit
 * @see Card
 */
public class Card {
    private int value;
    private String suit;
    private String face;

    /**
     * Card class constructor
     * @param value card value
     * @param suit card suit
     */
    public Card(int value, String suit){
        if (value > 13 || value < 0){
            throw new IllegalArgumentException("value is not valid");
        }
        if (value == 1){
            this.value = value;
            this.suit = suit;
            this.face = "A";
        }
        else if (value == 2){
            this.value = value;
            this.suit = suit;
            this.face = "2";
        }
        else if (value == 3){
            this.value = value;
            this.suit = suit;
            this.face = "3";
        } else if (value == 4){
            this.value = value;
            this.suit = suit;
            this.face = "4";
        }
        else if (value == 5){
            this.value = value;
            this.suit = suit;
            this.face = "5";
        }
        else if (value == 6){
            this.value = value;
            this.suit = suit;
            this.face = "6";
        }
        else if (value == 7){
            this.value = value;
            this.suit = suit;
            this.face = "7";
        } else if (value == 8){
            this.value = value;
            this.suit = suit;
            this.face = "8";
        }
        else if (value == 9){
            this.value = value;
            this.suit = suit;
            this.face = "9";
        }
        else if (value == 10){
            this.value = value;
            this.suit = suit;
            this.face = "10";
        }
        else if (value == 11){
            this.value = 10;
            this.suit = suit;
            this.face = "J";
        }
        else if (value == 12){
            this.value = 10;
            this.suit = suit;
            this.face = "Q";
        }
        else if (value == 13){
            this.value = 10;
            this.suit = suit;
            this.face = "K";
        }
    }

    /**
     * Method to access the value of the card
     * @return card value
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to print of card face and suit
     * @return String of card face and suit
     */
    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
