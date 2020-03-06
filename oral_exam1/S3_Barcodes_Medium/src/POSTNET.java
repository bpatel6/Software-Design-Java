/**
 * Implements the zipcode
 * @see POSTNET implements the method and function of Zipcode
 */
public class POSTNET {
    /**
     * long zipcode: to store the input zipcode
     */
    private String zipcode;
    /**
     * String Binaryzip: to store computed value of inputed zip in binary
     */
    private String BinaryZip;

    /**
     * To access the zipcode instance variable value
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * To set the zipcode instance variable value
     * @param zip code to be set to var. zipcode
     */
    public void setZipcode(String zip) {
        this.zipcode = zip;
    }

    /**
     * To access the store binary representation of the zipcode
     * @return BinaryZip
     */
    public String getBinaryZip() {
        return BinaryZip;
    }

    /**
     * To set the binary representation of the zipcode
     * @param binaryZip String of zipcode binary presentation
     */
    public void setBinaryZip(String binaryZip) {
        BinaryZip = binaryZip;
    }

    /**
     * Constructor to initialize input to the zipcode var.
     * @param input zipcode to initialize
     */
    public POSTNET(String input) {
        this.zipcode = input;
    }

    /**
     * Computes the checkdigit for the given input zip
     * @return checkdigit
     */
    public long checkdigit() {
        long sum = 0;
        int zip = Integer.parseInt(this.zipcode);
        while (zip != 0) {
            sum = sum + zip % 10;
            zip = zip / 10;
        }
        long checkdigit;
        checkdigit = 10 - (sum % 10);
        String newzip = this.zipcode + checkdigit;
        this.zipcode = String.valueOf(Long.parseLong(newzip));
        return checkdigit;
    }

    /**
     * Converts the given reference object zipcode  to the binary representation
     * @return binary graphical representationo of the zipcode
     */
    public String ziptobinary() {
        StringBuilder binary_graphical = new StringBuilder();
        StringBuilder binary_digit = new StringBuilder();
        String zip = this.zipcode;
        binary_graphical.append("|");
        binary_digit.append("1");
        for (int i = 0; i < zip.length(); i++) {
            if (zip.charAt(i) == '1') {
                binary_digit.append("00011");
                binary_graphical.append("...||");
            } else if (zip.charAt(i) == '2') {
                binary_digit.append("00101");
                binary_graphical.append("..|.|");
            } else if (zip.charAt(i) == '3') {
                binary_digit.append("00110");
                binary_graphical.append("..||.");
            } else if (zip.charAt(i) == '4') {
                binary_digit.append("01001");
                binary_graphical.append(".|..|");
            } else if (zip.charAt(i) == '5') {
                binary_digit.append("01010");
                binary_graphical.append(".|.|.");
            } else if (zip.charAt(i) == '6') {
                binary_digit.append("01100");
                binary_graphical.append(".||..");
            } else if (zip.charAt(i) == '7') {
                binary_digit.append("10001");
                binary_graphical.append("|...|");
            }
            else if (zip.charAt(i) == '8') {
                binary_digit.append("10010");
                binary_graphical.append("|..|.");
            } else if (zip.charAt(i) == '9') {
                binary_digit.append("10100");
                binary_graphical.append("|.|..");
            } else if (zip.charAt(i) == '0') {
                binary_digit.append("11000");
                binary_graphical.append("||...");
            }
        }
        binary_graphical.append("|");
        binary_digit.append("1");
        // Sets the value of zip in binary_digit to the binaryzip instance variable
        setBinaryZip(String.valueOf(binary_digit));
        return String.valueOf(binary_graphical);
    }

    /**
     * Converts the given reference object from binary to zipcode
     * @return binary graphical representationo of the zipcode
     */
    public String decrypt() {
        StringBuilder zip = new StringBuilder();
        for (int i = 1; i < BinaryZip.length() - 1; i = i + 5) {
            if (BinaryZip.substring(i, i + 5).equals("00011")) {
                zip.append('1');
            } else if (BinaryZip.substring(i, i + 5).equals("00101")) {
                zip.append('2');
            } else if (BinaryZip.substring(i, i + 5).equals("00110")) {
                zip.append('3');
            } else if (BinaryZip.substring(i, i + 5).equals("01001")) {
                zip.append('4');
            } else if (BinaryZip.substring(i, i + 5).equals("01010")) {
                zip.append('5');
            } else if (BinaryZip.substring(i, i + 5).equals("01100")) {
                zip.append('6');
            } else if (BinaryZip.substring(i, i + 5).equals("10001")) {
                zip.append('7');
            }
            else if (BinaryZip.substring(i, i + 5).equals("10010")) {
                zip.append('8');
            } else if (BinaryZip.substring(i, i + 5).equals("10100")) {
                zip.append('9');
            } else if (BinaryZip.substring(i, i + 5).equals("11000")) {
                zip.append('0');
            }
        }
        return String.valueOf(zip);
    }
}
