public class Payment {
    private String randName;
    private int nextInt;
    private String randName1;

    public Payment(String randName, int nextInt, String randName1) {
        this.randName = randName;
        this.nextInt = nextInt;
        this.randName1 = randName1;
    }

    @Override
    public String toString() {
        return "Payment Sender: " + randName + '\n' +
                "Payment amount: $" + nextInt + '\n' +
                "Payment receiver: " + randName1;
    }
}
