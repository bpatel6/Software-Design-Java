public class UPC {
    private String upc;
    private String encryptedupc;
    private int checkdigit;
    public String getupc() {
        return upc;
    }
    public void setupc(String upc) {
        this.upc = upc;
    }
    public int getCheckdigit() {
        return checkdigit;
    }
    public String getEncryptedupc() {
        return encryptedupc;
    }

    public void setEncryptedupc(String encryptedupc) {
        this.encryptedupc = encryptedupc;
    }
    public void setCheckdigit(int checkdigit) {
        this.checkdigit = checkdigit;
    }

    public UPC(String input){
        this.upc = input;
    }
    public long checksum(){
        int sumeven = 0;
        int sumodd = 0;
        int finalsum = 0;
        for (int i = 0; i < upc.length(); i++){
            if (i%2 == 0){
                sumodd += Integer.parseInt(String.valueOf(upc.charAt(i)));
            }
            else {
                sumeven += Integer.parseInt(String.valueOf(upc.charAt(i)));
            }
        }
        finalsum = (sumodd*3) + sumeven;
        if (finalsum%10 == 0){
            checkdigit = 0;
        }
        else {
            checkdigit = 10 - (finalsum%10);
        }
        upc = upc + checkdigit;
        return checkdigit;
    }

    public String encrypt(){
        StringBuilder buildencrypt = new StringBuilder();
        buildencrypt.append("101 ");
        buildencrypt.append(encryptleft(upc.substring(0,6)));
        buildencrypt.append(" 01010 ");
        buildencrypt.append(encryptright(upc.substring(6,12)));
        buildencrypt.append(" 101");
        this.encryptedupc = String.valueOf(buildencrypt);
        return encryptedupc;
    }

    public String decrypt(String input){
        StringBuilder build = new StringBuilder();
        String left = input.substring(4,46);
        String right = input.substring(53,95);
        build.append(decrypthelper(left));
        build.append(decrypthelper(input.substring(53,95)));
        return String.valueOf(build);
    }

    public StringBuilder encryptleft(String input){
        StringBuilder binary = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '0'){
                binary.append("0001101");
            }
            else if (input.charAt(i) == '1') {
                binary.append("0011001");
            }
            else if (input.charAt(i) == '2') {
                binary.append("0010011");
            }
            else if (input.charAt(i) == '3') {
                binary.append("0111101");
            }
            else if (input.charAt(i) == '4') {
                binary.append("0100011");
            }
            else if (input.charAt(i) == '5') {
                binary.append("0110001");
            }
            else if (input.charAt(i) == '6') {
                binary.append("0101111");
            }
            else if (input.charAt(i) == '7') {
                binary.append("0111011");
            }
            else if (input.charAt(i) == '8') {
                binary.append("0110111");
            }
            else if (input.charAt(i) == '9') {
                binary.append("0001011");
            }
        }
        return binary;
    }

    public StringBuilder encryptright(String input){
        StringBuilder binary = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '0'){
                binary.append("1110010");
            }
            else if (input.charAt(i) == '1') {
                binary.append("1100110");
            }
            else if (input.charAt(i) == '2') {
                binary.append("1101100");
            }
            else if (input.charAt(i) == '3') {
                binary.append("1000010");
            }
            else if (input.charAt(i) == '4') {
                binary.append("1011100");
            }
            else if (input.charAt(i) == '5') {
                binary.append("1001110");
            }
            else if (input.charAt(i) == '6') {
                binary.append("1010000");
            }
            else if (input.charAt(i) == '7') {
                binary.append("1000100");
            }
            else if (input.charAt(i) == '8') {
                binary.append("1001000");
            }
            else if (input.charAt(i) == '9') {
                binary.append("1110100");
            }
        }
        return binary;
    }

    public String decrypthelper(String input){
        StringBuilder upc = new StringBuilder();
        for (int i = 0; i < input.length(); i = i+7){
            if (input.substring(i, i + 7).equals("0001101") || input.substring(i, i + 7).equals("1110010")){
                upc.append("0");
            }
            else if (input.substring(i, i + 7).equals("0011001") || input.substring(i, i + 7).equals("1100110")){
                upc.append("1");
            }
            else if (input.substring(i, i + 7).equals("0010011") || input.substring(i, i + 7).equals("1101100")){
                upc.append("2");
            }
            else if (input.substring(i, i + 7).equals("0111101") || input.substring(i, i + 7).equals("1000010")){
                upc.append("3");
            }
            else if (input.substring(i, i + 7).equals("0100011") || input.substring(i, i + 7).equals("1011100")){
                upc.append("4");
            }
            else if (input.substring(i, i + 7).equals("0110001") || input.substring(i, i + 7).equals("1001110")){
                upc.append("5");
            }
            else if (input.substring(i, i + 7).equals("0101111") || input.substring(i, i + 7).equals("1010000")){
                upc.append("6");
            }
            else if (input.substring(i, i + 7).equals("0111011") || input.substring(i, i + 7).equals("1000100")){
                upc.append("7");
            }
            else if (input.substring(i, i + 7).equals("0110111") || input.substring(i, i + 7).equals("1001000")){
                upc.append("8");
            }
            else if (input.substring(i, i + 7).equals("0001011") || input.substring(i, i + 7).equals("1110100")) {
                upc.append("9");
            }
        }
        return String.valueOf(upc);
    }
}
