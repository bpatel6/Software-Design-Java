/**
 * The class to test deck functions
 * @see DeckTest
 */
public class DeckTest {
    public static void main(String[] args) {
        Deck i = new Deck();
        i.shuffle();
        i.printDeck();
        System.out.println(i.getCard().toString());
        System.out.println(i.getCard().toString());
    }
}
