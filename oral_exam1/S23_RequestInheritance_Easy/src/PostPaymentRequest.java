import java.util.UUID;

public class PostPaymentRequest extends PostRequest {
    private static int postpaymentcount;
    protected Payment randPayment;
    protected String randIP;

    public PostPaymentRequest() {

    }

    public static int getPostpaymentcount() {
        return postpaymentcount;
    }

    public static void setPostpaymentcount(int postpaymentcount) {
        PostPaymentRequest.postpaymentcount = postpaymentcount;
    }



    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) {
        postpaymentcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        super.randIP = randIP;
        this.randPayment = randPayment;
        super.randUUID = randUUID;
    }

    @Override
    public String toString() {
        return super.toString() +
                randPayment;
    }

    public static String count() {
        return String.valueOf(postpaymentcount);
    }
}
