import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the zipcode:");
        long thezip = input.nextLong();
        POSTNET post = new POSTNET(thezip);
        System.out.println(post.getZipcode());
        System.out.println(post.checksum());
        System.out.println(post.getZipcode());
        System.out.println(post.ziptobinary());

        UPC a = new UPC("01254667375");
        System.out.println(a.checksum());
        System.out.println(a.getupc());
        a.encrypt();
       // System.out.println(a.encrypt());
        System.out.println(a.decrypt(a.getEncryptedupc()));
        UPC b = new UPC("01231564313");
        b.checksum();
        System.out.println(b.encrypt());
        System.out.println(b.decrypt(b.getEncryptedupc()));
    }
}
