public class UPC {
    private String upc;

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
        System.out.println(sumeven);
        System.out.println(sumodd);
        finalsum = (sumodd*3) + sumeven;
        System.out.println(finalsum);
        if (finalsum%10 == 0){
            checkdigit = 0;
        }
        else {
            checkdigit = 10 - (finalsum%10);
        }
        upc = upc + checkdigit;
        return checkdigit;
    }
}
