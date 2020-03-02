import java.util.UUID;

public class PostRequest extends Request {
    private static int postcounts;

    public static int getPostcounts() {
        return postcounts;
    }

    public static void setPostcounts(int postcounts) {
        PostRequest.postcounts = postcounts;
    }

    private UUID randUUID;
    private String randIP;

    public PostRequest(UUID randUUID, String randIP) {
        postcounts++;
        Request.setCount(Request.getCount() + 1);
        this.randIP = randIP;
        this.randUUID = randUUID;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' +
                "Post request to server with IP address: " + randIP;
    }

    public static String count(){
        return String.valueOf(postcounts);
    }
}
