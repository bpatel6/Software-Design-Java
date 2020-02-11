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

    }
}
