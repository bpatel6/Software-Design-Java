/**
 * The class to present Payment data
 * @see Payment
 */

public class Payment {
    /**
     * randName - to store a random name
     */
    private String randName;
    /**
     * nextInt - to store a random integer
     */
    private int nextInt;
    /**
     * randName2 - to store a random name
     */
    private String randName1;

    /**
     * Constructor with randName, nextInt and randName2 initialization
     * @param randName String - Random name
     * @param nextInt Integer - Random integer
     * @param randName1 String - Random name
     */
    public Payment(String randName, int nextInt, String randName1) {
        this.randName = randName;
        this.nextInt = nextInt;
        this.randName1 = randName1;
    }

    /**
     * Prints randname, nextInt and randName1
     * @return String with randname, nextInt and randName1
     */
    @Override
    public String toString() {
        return "Payment Sender: " + randName + '\n' +
                "Payment amount: $" + nextInt + '\n' +
                "Payment receiver: " + randName1;
    }
}
