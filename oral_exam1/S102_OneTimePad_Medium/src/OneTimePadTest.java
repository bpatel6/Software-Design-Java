
/**
 * @see OneTimePadTest The class to test all function and method of OneTimePad program
 */
public class OneTimePadTest {
    public static void main(String[] args) {
        System.out.println("TEST 1 - EASY: I LOVE SOFTWARE DESIGN");
        OneTimePad p1 = new OneTimePad("I LOVE SOFTWARE DESIGN");
        System.out.println("Cipher: " + p1.encrypt());
        System.out.println("Decrypted: " + p1.decrypt());

        System.out.println("TESt 2 - MEDIUM: I LOVE SOFTWARE DESIGN");
        OneTimePad p2 = new OneTimePad("I LOVE SOFTWARE DESIGN");
        System.out.println("Cipher: " + p2.encryptmedium());
        System.out.println("Decrypted: " + p2.decryptmedium());

        System.out.println("TEST 3: - MEDIUM: HEHE YOU ARE THE BEST");
        OneTimePad p3 = new OneTimePad("HEHE YOU ARE THE BEST");
        System.out.println("Cipher: " + p3.encryptmedium());
        System.out.println("Decrypted: " + p3.decryptmedium());

        System.out.println("TEST 4: - MEDIUM: UNIVERSITY OF IOWA");
        OneTimePad p4 = new OneTimePad("UNIVERSITY OF IOWA");
        System.out.println("Cipher: " + p4.encryptmedium());
        System.out.println("Decrypted: " + p4.decryptmedium());

    }
}
