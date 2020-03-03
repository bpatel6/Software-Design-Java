import java.util.UUID;

public class PostEncryptedPaymentRequest extends Request {
    private static int encryptedpaymentcount;
    private UUID randUUID;
    private String randIP, randEncryptionsScheme;
    private Payment randPayment;

    public static int getEncryptedpaymentcount() {
        return encryptedpaymentcount;
    }

    public static void setEncryptedpaymentcount(int encryptedpaymentcount) {
        PostEncryptedPaymentRequest.encryptedpaymentcount = encryptedpaymentcount;
    }

    public PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncryptionScheme) {
        encryptedpaymentcount++;
        PostPaymentRequest.setPostpaymentcount(PostPaymentRequest.getPostpaymentcount() + 1);
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randEncryptionsScheme = randEncryptionScheme;
        this.randPayment = randPayment;
        this.randUUID = randUUID;
        this.randIP = randIP;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' +
                "Post request to server with IP address: " + randIP + '\n' +
                "Payment Data" + '\n' + randPayment + '\n' +
                "This payment was encrypted using: " + randEncryptionsScheme;
    }

    public static String count() {
        return String.valueOf(encryptedpaymentcount);
    }
}
