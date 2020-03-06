import java.util.UUID;

/**
 * The class to present PostPaymentRequest data
 * @see PostPaymentRequest
 */
public class PostPaymentRequest extends PostRequest {
    /**
     * postpaymentcount - to keep track of all post payment requests
     */
    private static int postpaymentcount;
    /**
     * randPayment - to keep track of a payment transactions
     */
    protected Payment randPayment;
    /**
     * randIP - to save randIP generated
     */
    protected String randIP;

    /**
     * Default constructor
     */
    public PostPaymentRequest() {

    }

    /**
     * to access the value of postpaymentcount var.
     * @return integer - postpaymentcount var. value
     */
    public static int getPostpaymentcount() {
        return postpaymentcount;
    }

    /**
     * to set the value of postpaymentcount var.
     * @param postpaymentcount integer - to be set to the postpaymentcount var.
     */
    public static void setPostpaymentcount(int postpaymentcount) {
        PostPaymentRequest.postpaymentcount = postpaymentcount;
    }


    /**
     * Constructor with randUUID, randIP and Payment initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randIP IP - to be initialized with an object
     * @param randPayment Payment - to be initialized with an object
     */
    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) {
        postpaymentcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        super.randIP = randIP;
        this.randPayment = randPayment;
        super.randUUID = randUUID;
    }

    /**
     * Prints Object address, UUID, IP and Payment info
     * @return String with object address, UUID, IP and Payment info
     */
    @Override
    public String toString() {
        return super.toString() +
                randPayment;
    }

    /**
     * to access the value of postpaymentcount
     * @return integer - postpaymentcount var. value
     */
    public static int count() {
        return postpaymentcount;
    }
}
