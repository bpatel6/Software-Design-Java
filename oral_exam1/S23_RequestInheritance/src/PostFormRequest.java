import java.util.UUID;

public class PostFormRequest extends Request {
    private static int postformcount;
    private UUID randUUID;

    public static int getPostformcount() {
        return postformcount;
    }

    public static void setPostformcount(int postformcount) {
        PostFormRequest.postformcount = postformcount;
    }

    private String randIP;
    private Form randForm;

    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        postformcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randUUID = randUUID;
        this.randIP = randIP;
        this.randForm = randForm;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' +
                "Post request to server with IP address: " + randIP + '\n' +
                randForm;
    }

    public static String count() {
        return String.valueOf(postformcount);
    }
}
