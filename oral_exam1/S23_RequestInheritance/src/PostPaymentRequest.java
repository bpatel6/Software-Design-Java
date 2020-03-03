import java.util.UUID;

public class PostPaymentRequest extends Request {
    private static int postpaymentcount;
    private UUID randUUID;

    public static int getPostpaymentcount() {
        return postpaymentcount;
    }

    public static void setPostpaymentcount(int postpaymentcount) {
        PostPaymentRequest.postpaymentcount = postpaymentcount;
    }

    private String randIP;
    private Payment randPayment;

    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) {
        postpaymentcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randIP = randIP;
        this.randPayment = randPayment;
        this.randUUID = randUUID;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' +
                "Post request to server with IP address: " + randIP + '\n' +
                randPayment;
    }

    public static String count() {
        return String.valueOf(postpaymentcount);
    }
}
