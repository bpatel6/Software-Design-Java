/**
 * Implements the UPC Barcode
 * @see UPC implements the method and functions of UPC product code
 */
public class UPC {
    /**
     * String upc: stores the UPC product code
     */
    private String upc;
    /**
     * String encryptedupc: stores the encrypted value of the UPC product code
     */
    private String encryptedupc;
    /**
     * int checkdigit: store the computed check digit of the UPC product code
     */
    private int checkdigit;

    /**
     * To access the value of upc var.
     * @return return the value upc var.
     */
    public String getupc() {
        return upc;
    }

    /**
     * To set the value of upc var.
     * @param upc the value to set upc var.
     */
    public void setupc(String upc) {
        this.upc = upc;
    }

    /**
     * To access the value of checkdigit var.
     * @return return the value of checkdigit var.
     */
    public int getCheckdigit() {
        return checkdigit;
    }

    /**
     * To acess the value of encryptedupc var.
     * @return return the value of encryptedupc var.
     */
    public String getEncryptedupc() {
        return encryptedupc;
    }

    /**
     * To set the value of encryptedupc var.
     * @param encryptedupc set the value of encryptedupc var.
     */
    public void setEncryptedupc(String encryptedupc) {
        this.encryptedupc = encryptedupc;
    }

    /**
     * To set the value of checkdigit var.
     * @param checkdigit passed value set to checkdigit var.
     */
    public void setCheckdigit(int checkdigit) {
        this.checkdigit = checkdigit;
    }

    /**
     * Constructor to initialize the upc var. value
     * @param input passed UPC product value set to the upc var.
     */
    public UPC(String input) {
        this.upc = input;
    }

    /**
     * To compute the checkdigit for the referred UPC object
     * @return computed checkdigit number for the 11 digit UPC product code
     */
    public long checkdigit() {
        int sumeven = 0;
        int sumodd = 0;
        int finalsum;
        for (int i = 0; i < upc.length(); i++) {
            if (i % 2 == 0) {
                sumodd += Integer.parseInt(String.valueOf(upc.charAt(i)));
            } else {
                sumeven += Integer.parseInt(String.valueOf(upc.charAt(i)));
            }
        }
        finalsum = (sumodd * 3) + sumeven;
        if (finalsum % 10 == 0) {
            checkdigit = 0;
        } else {
            checkdigit = 10 - (finalsum % 10);
        }
        upc = upc + checkdigit;
        return checkdigit;
    }

    /**
     * To encrypt to UPC into binary representation
     * @return binary representation of the UPC code
     */
    public String encrypt() {
        StringBuilder buildencrypt = new StringBuilder();
        buildencrypt.append("101");
        buildencrypt.append(encryptleft(upc.substring(0, 6)));
        buildencrypt.append("01010");
        buildencrypt.append(encryptright(upc.substring(6, 12)));
        buildencrypt.append("101");
        this.encryptedupc = String.valueOf(buildencrypt);
        return encryptedupc;
    }

    /**
     * To decrypt the binary representation of the UPC code
     * @param input binary represented upc code
     * @return UPC code
     */
    public static String decrypt(String input) {
        StringBuilder build = new StringBuilder();
        String left = input.substring(3, 45);
        build.append(decrypthelper(left));
        build.append(decrypthelper(input.substring(50, 92)));
        System.out.println("Checkdigit is: " + build.charAt(11));
        return String.valueOf(build);
    }

    /**
     * To encrypt left digit of the UPC product code
     * @param input UPC product code left most 6 digits of the UPC code
     * @return Binary presentation of the left most 6 digit of the UPC code
     */
    public StringBuilder encryptleft(String input) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                binary.append("0001101");
            } else if (input.charAt(i) == '1') {
                binary.append("0011001");
            } else if (input.charAt(i) == '2') {
                binary.append("0010011");
            } else if (input.charAt(i) == '3') {
                binary.append("0111101");
            } else if (input.charAt(i) == '4') {
                binary.append("0100011");
            } else if (input.charAt(i) == '5') {
                binary.append("0110001");
            } else if (input.charAt(i) == '6') {
                binary.append("0101111");
            } else if (input.charAt(i) == '7') {
                binary.append("0111011");
            } else if (input.charAt(i) == '8') {
                binary.append("0110111");
            } else if (input.charAt(i) == '9') {
                binary.append("0001011");
            }
        }
        return binary;
    }

    /**
     * To encrypt right digits of the UPC code
     * @param input UPC product code right most 6 digits of the UPC code
     * @return Binary presentation of the right most 6 digit of the UPC code
     */
    public StringBuilder encryptright(String input) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                binary.append("1110010");
            } else if (input.charAt(i) == '1') {
                binary.append("1100110");
            } else if (input.charAt(i) == '2') {
                binary.append("1101100");
            } else if (input.charAt(i) == '3') {
                binary.append("1000010");
            } else if (input.charAt(i) == '4') {
                binary.append("1011100");
            } else if (input.charAt(i) == '5') {
                binary.append("1001110");
            } else if (input.charAt(i) == '6') {
                binary.append("1010000");
            } else if (input.charAt(i) == '7') {
                binary.append("1000100");
            } else if (input.charAt(i) == '8') {
                binary.append("1001000");
            } else if (input.charAt(i) == '9') {
                binary.append("1110100");
            }
        }
        return binary;
    }

    /**
     * Helper function to decrypt the binary presented UPC code
     * @param input Binary representation of the UPC code
     * @return UPC code
     */
    public static String decrypthelper(String input) {
        StringBuilder upc = new StringBuilder();
        for (int i = 0; i < input.length(); i = i + 7) {
            if (input.substring(i, i + 7).equals("0001101") || input.substring(i, i + 7).equals("1110010")) {
                upc.append("0");
            } else if (input.substring(i, i + 7).equals("0011001") || input.substring(i, i + 7).equals("1100110")) {
                upc.append("1");
            } else if (input.substring(i, i + 7).equals("0010011") || input.substring(i, i + 7).equals("1101100")) {
                upc.append("2");
            } else if (input.substring(i, i + 7).equals("0111101") || input.substring(i, i + 7).equals("1000010")) {
                upc.append("3");
            } else if (input.substring(i, i + 7).equals("0100011") || input.substring(i, i + 7).equals("1011100")) {
                upc.append("4");
            } else if (input.substring(i, i + 7).equals("0110001") || input.substring(i, i + 7).equals("1001110")) {
                upc.append("5");
            } else if (input.substring(i, i + 7).equals("0101111") || input.substring(i, i + 7).equals("1010000")) {
                upc.append("6");
            } else if (input.substring(i, i + 7).equals("0111011") || input.substring(i, i + 7).equals("1000100")) {
                upc.append("7");
            } else if (input.substring(i, i + 7).equals("0110111") || input.substring(i, i + 7).equals("1001000")) {
                upc.append("8");
            } else if (input.substring(i, i + 7).equals("0001011") || input.substring(i, i + 7).equals("1110100")) {
                upc.append("9");
            }
        }
        return String.valueOf(upc);
    }
}
