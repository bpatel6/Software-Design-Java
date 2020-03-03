import java.util.UUID;

public class PostEncryptedPaymentRequest extends PostPaymentRequest {
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
        super();
        encryptedpaymentcount++;
        PostPaymentRequest.setPostpaymentcount(PostPaymentRequest.getPostpaymentcount() + 1);
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randEncryptionsScheme = randEncryptionScheme;
        super.randPayment = randPayment;
        super.randUUID = randUUID;
        super.randIP = randIP;
    }

    @Override
    public String toString() {
        return super.toString() +
                "This payment was encrypted using: " + randEncryptionsScheme;
    }

    public static String count() {
        return String.valueOf(encryptedpaymentcount);
    }
}
