import java.util.UUID;

/**
 * The class to present PostEncryptedPaymentRequest data
 * @see PostEncryptedPaymentRequest
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {
    /**
     * encryptedpaymentcount - to keep track of all encrypted payment requests
     */
    private static int encryptedpaymentcount;
    /**
     * randEncryptionsScheme - to save randEncryptionsScheme generated
     */
    private String randEncryptionsScheme;

    /**
     * Constructor with randUUID, randIP, randPayment and randEncryptionScheme initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randIP IP - to be initialized with and object
     * @param randPayment Payment - to be initialized with an object
     * @param randEncryptionScheme EncryptionScheme - to be initialized with an object
     */
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

    /**
     * Prints Object address, UUID, IP, Payment and Encryption Scheme info
     * @return String with object address, UUID, IP, Payment and Encryption Scheme info
     */
    @Override
    public String toString() {
        return super.toString() +
                "This payment was encrypted using: " + randEncryptionsScheme;
    }

    /**
     * to access the value of encryptedpaymentcount
     * @return integer - encryptedpaymentcount var. value
     */
    public static int count() {
        return encryptedpaymentcount;
    }
}
