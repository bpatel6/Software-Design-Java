public class POSTNET {
    /**
     * long zipcode: to store the input zipcode
     * string Binaryzip: to store computed value of inputed zip in binary
     */
    private long zipcode;
    private String BinaryZip;

    /**
     * To access the zipcode instance variable value
     *
     * @return zipcode
     */
    public long getZipcode() {
        return zipcode;
    }

    /**
     * To set the zipcode instance variable value
     *
     * @return no return
     */
    public void setZipcode(long zip) {
        this.zipcode = zip;
    }

    /**
     *
     * @return
     */
    public String getBinaryZip() {
        return BinaryZip;
    }

    /**
     *
     * @param binaryZip
     */
    public void setBinaryZip(String binaryZip) {
        BinaryZip = binaryZip;
    }

    /**
     *
     * @param input
     */
    public POSTNET(long input) {
        this.zipcode = input;
    }

    /**
     *
     * @return
     */
    public long checksum() {
        long sum = 0;
        long zip = this.zipcode;
        while (zip != 0) {
            sum = sum + zip % 10;
            zip = zip / 10;
        }
        long checkdigit;
        checkdigit = 10 - (sum % 10);
        sum = sum + checkdigit;
        String newzip = this.zipcode + String.valueOf(checkdigit);
        this.zipcode = Long.parseLong(newzip);
        return checkdigit;
    }

    /**
     *
     * @return
     */
    public String ziptobinary() {
        StringBuilder binary = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        String zip = Long.toString(this.zipcode);
        binary.append("|");
        digit.append("1");
        for (int i = 0; i < zip.length(); i++) {
            if (zip.charAt(i) == '1') {
                digit.append("00011");
                binary.append("...||");
            } else if (zip.charAt(i) == '2') {
                digit.append("00101");
                binary.append("..|.|");
            } else if (zip.charAt(i) == '3') {
                digit.append("00110");
                binary.append("..||.");
            } else if (zip.charAt(i) == '4') {
                digit.append("01001");
                binary.append(".|..|");
            } else if (zip.charAt(i) == '5') {
                digit.append("01010");
                binary.append(".|.|.");
            } else if (zip.charAt(i) == '6') {
                digit.append("01100");
                binary.append(".||..");
            } else if (zip.charAt(i) == '7') {
                digit.append("10001");
                binary.append("|...|");
            }
            if (zip.charAt(i) == '8') {
                digit.append("10010");
                binary.append("|..|.");
            } else if (zip.charAt(i) == '9') {
                digit.append("10100");
                binary.append("|.|..");
            } else if (zip.charAt(i) == '0') {
                digit.append("11000");
                binary.append("||...");
            }
        }
        binary.append("|");
        digit.append("1");
        // Sets the value of zip in binary digit to binaryzip instance variable
        setBinaryZip(String.valueOf(digit));
        return String.valueOf(binary);
    }
}
