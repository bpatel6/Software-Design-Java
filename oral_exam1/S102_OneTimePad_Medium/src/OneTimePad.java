import java.util.Arrays;
import java.util.Random;

/**
 * The class implements cypher text encryption and decryption
 * @see OneTimePad implements the method and funtion to encrypt and decrypt cypher text
 */
public class OneTimePad {
    /**
     * Alphabets[] - stores all the alphabets and remains same throughout program
     */
    private final char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    /**
     * Increment_n - It's 13 for easy encryption. To increment the indices of alphabets during encryption
     */
    private int increment_n;
    /**
     * n_numbers - stores the value of random number during the process of encryption in medium part
     */
    private int[] n_numbers;
    /**
     * text - stores the given input text, sets in constructor
     */
    private String text;
    /**
     * encryptedtext - stores the encrypted text
     */
    private String encryptedtext;
    /**
     * decryptiontext - stores the decryption text
     */
    private String decryptedtext;
    /**
     * Gets the value of text
     * @return text - text passed in constructor
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of text
     * @param text - passed a text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the value of encrypted text
     * @return the value of encrypted text
     */
    public String getEncryptedtext() {
        return encryptedtext;
    }

    /**
     * Sets the value of encrypted text
     * @param encryptedtext the String to be set
     */
    public void setEncryptedtext(String encryptedtext) {
        this.encryptedtext = encryptedtext;
    }


    /**
     * Constructor to create a class object
     * @param input String to initialize a OneTimePad object
     */
    public OneTimePad(String input) {
        this.text = input;
        this.increment_n = 13;
    }

    /**
     * Encrypts the OneTimePad object text
     * @return encrypted version of the text
     */
    public String encrypt() {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                build.append(" ");
                i++;
            }
            for (int j = 0; j < alphabets.length; j++) {
                if (text.charAt(i) == alphabets[j]) {
                    if ((j + 13) <= 25) {
                        build.append(alphabets[j + 13]);
                    } else {
                        build.append(alphabets[(j + 13) % 26]);
                    }
                }
            }
        }
        encryptedtext = String.valueOf(build);
        return encryptedtext;
    }

    /**
     * Decrypts the OneTimePad Object encrypted text
     * @return decrypted version of encrypted text
     */
    public String decrypt() {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < encryptedtext.length(); i++){
            if (encryptedtext.charAt(i) == ' ') {
                build.append(" ");
                i++;
            }
            for (int j = 0; j < alphabets.length; j++) {
                if (encryptedtext.charAt(i) == alphabets[j]){
                    if (((j - 13) <= 25) && ((j - 13) >= 0)) {
                        build.append(alphabets[j - 13]);
                    }
                    else if((j-13) <= 0){
                        build.append(alphabets[26 + (j-13)]);
                    }
                }
            }
        }

        decryptedtext = String.valueOf(build);
        return decryptedtext;
    }


    /**
     * Encrypts the OneTimePad object text by generating different n value increment for alphabets
     * @return encrypted text with random n values for all alphabets in a String
     */
    public String encryptmedium() {
        StringBuilder build = new StringBuilder();
        n_numbers = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                build.append(" ");
                n_numbers[i] = 1234;
                i++;
            }
            Random rand = new Random();
            int random_n = rand.nextInt(26);
            n_numbers[i] = random_n;
            for (int j = 0; j < alphabets.length; j++) {
                if (text.charAt(i) == alphabets[j]) {
                    if ((j + random_n) <= 25) {
                        build.append(alphabets[j + random_n]);
                    } else {
                        build.append(alphabets[((j + random_n) % 26)]);
                    }
                }
            }
        }
        System.out.println(toString(n_numbers));
        encryptedtext = String.valueOf(build);
        return encryptedtext;
    }

    /**
     * Decrypts the OneTimePad object encrypted text
     * @return decrypted text value
     */
    public String decryptmedium(){
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < encryptedtext.length(); i++){
            if (encryptedtext.charAt(i) == ' ') {
                build.append(" ");
                i++;
            }
            for (int j = 0; j < alphabets.length; j++) {
                if (encryptedtext.charAt(i) == alphabets[j]){
                    if (((j - n_numbers[i]) <= 25) && ((j - n_numbers[i]) >= 0)) {
                        build.append(alphabets[j - n_numbers[i]]);
                    }
                    else if((j- n_numbers[i]) <= 0){
                        build.append(alphabets[26 + (j- n_numbers[i])]);
                    }
                }
            }
        }
        decryptedtext = String.valueOf(build);
        return decryptedtext;
    }

    /**
     * Helper print method to print random value of n during encryptmedium()
     * @param a Array containing all random n values
     * @return String representation of all stored n value in an array
     */
    public static String toString(int[] a){
        StringBuilder build = new StringBuilder();
        if (a == null){
            return null;
        }
        else {
            for(int i = 0; i < a.length; i++){
                if (a[i] == 1234){
                    build.append(' ');
                }
                else {
                    build.append(a[i]);
                    build.append(' ');
                }
            }
        }
        return String.valueOf(build);
    }
}
