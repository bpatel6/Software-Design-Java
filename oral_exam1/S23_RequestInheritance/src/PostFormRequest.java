import java.util.UUID;

public class PostFormRequest extends PostRequest {
    private static int postformcount;
    protected Form randForm;

    public PostFormRequest() {

    }

    public static int getPostformcount() {
        return postformcount;
    }

    public static void setPostformcount(int postformcount) {
        PostFormRequest.postformcount = postformcount;
    }



    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        super();
        postformcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        super.randUUID = randUUID;
        super.randIP = randIP;
        this.randForm = randForm;
    }

    @Override
    public String toString() {
        return super.toString() +  '\n' +
                randForm;
    }

    public static String count() {
        return String.valueOf(postformcount);
    }
}
