import java.util.Random;

public class Deck {
    private final String[] suits = {"Heart", "Diamond", "Spade", "Club"};
    private final int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private Card[] deck;

    public Deck(){
        deck = new Card[52];
        int k = 0;
        for (String suit : suits) {
            for (int value : values) {
                deck[k] = new Card(value, suit);
                k++;
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < 52; i++){
            int random = i + rand.nextInt(52 - i);
            Card temp = deck[random];
            deck[random] = deck[i];
            deck[i] = temp;
        }
    }

    public void printDeck(){
        for (int i = 0; i < 52; i++){
            System.out.println(deck[i].toString());
        }
    }
}
