public class POSTNET {
    private long zipcode;
    public long getZipcode() {
        return zipcode;
    }
    public void setZipcode(long zip) {
        this.zipcode = zip;
    }
    public POSTNET(long input){
        this.zipcode = input;
    }
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
        String newzip = String.valueOf(this.zipcode) + String.valueOf(checkdigit);
        System.out.println(newzip);
        this.zipcode = Long.parseLong(newzip);
        return sum;
    }
    public StringBuilder ziptobinary(){
        StringBuilder binary = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        String zip = Long.toString(this.zipcode);
        for (int i = 0; i < zip.length(); i++){
            binary.append("|");
            if (zip.charAt(i) == '1'){
                digit.append("00011");
                binary.append("...||");
            }
            if (zip.charAt(i) == '2'){
                digit.append("00101");
                binary.append("..|.|");
            }
            if (zip.charAt(i) == '3'){
                digit.append("00110");
                binary.append("..||.");
            }
            if (zip.charAt(i) == '4'){
                digit.append("01001");
                binary.append(".|..|");
            }
            if (zip.charAt(i) == '5'){
                digit.append("01010");
                binary.append(".|.|.");
            }
            if (zip.charAt(i) == '6'){
                digit.append("01100");
                binary.append(".||..");
            }
            if (zip.charAt(i) == '7'){
                digit.append("10001");
                binary.append("|...|");
            }
            if (zip.charAt(i) == '8'){
                digit.append("10010");
                binary.append("|..|.");
            }
            if (zip.charAt(i) == '9'){
                digit.append("10100");
                binary.append("|.|..");
            }
            if (zip.charAt(i) == '0'){
                digit.append("11000");
                binary.append("||...");
            }
            binary.append("|");
        }
        System.out.println(binary);
        return digit;
    }
}
