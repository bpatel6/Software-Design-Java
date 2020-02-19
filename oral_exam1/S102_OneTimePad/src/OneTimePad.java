import java.util.Random;

public class OneTimePad {
    final char alphabets[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private int n;
    private String text;
    private String encryptedtext;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public OneTimePad(String input){
        this.text = input;
        this.n = 13;
    }

    public String encrypt(){
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                build.append(" ");
                i++;
            }
            for (int j = 0; j < alphabets.length; j++){
                if (text.charAt(i) == alphabets[j]){
                    if ((j+13) <= 25){
                        build.append(alphabets[j+13]);
                    }
                    else {
                        build.append(alphabets[(j+13)%13]);
                    }
                }
            }
        }
        encryptedtext = String.valueOf(build);
        return String.valueOf(build);
    }

    public String encryptmedium(){
        StringBuilder build = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                number.append(" ");
                build.append(" ");
                i++;
            }
            Random rand = new Random();
            int random_n = rand.nextInt(26);
            number.append(random_n + " ");
            for (int j = 0; j < alphabets.length; j++){
                if (text.charAt(i) == alphabets[j]){
                    if ((j+random_n) <= 25){
                        build.append(alphabets[j+random_n] + " ");
                    }
                    else {
                        build.append(alphabets[(j+random_n)%random_n] + " ");
                    }
                }
            }
        }
        System.out.println(number);
        return String.valueOf(build);
    }
}
