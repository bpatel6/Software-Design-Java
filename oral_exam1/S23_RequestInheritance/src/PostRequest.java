import java.util.UUID;

public class PostRequest extends Request {
    protected String randIP;
    private static int postcounts;

    public PostRequest() {

    }

    public static int getPostcounts() {
        return postcounts;
    }

    public static void setPostcounts(int postcounts) {
        PostRequest.postcounts = postcounts;
    }


    public PostRequest(UUID randUUID, String randIP) {
        postcounts++;
        Request.setCount(Request.getCount() + 1);
        this.randIP = randIP;
        super.randUUID = randUUID;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Post request to server with IP address: " + randIP;
    }

    public static String count() {
        return String.valueOf(postcounts);
    }
}
