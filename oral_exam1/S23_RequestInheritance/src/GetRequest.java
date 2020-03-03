import java.util.UUID;

public class GetRequest extends Request {
    private static int getcounts;

    public static int getGetcounts() {
        return getcounts;
    }

    public static void setGetcounts(int getcounts) {
        GetRequest.getcounts = getcounts;
    }

    private UUID randUUID;
    private String randURL;

    public GetRequest(UUID randUUID, String randURL) {
        getcounts++;
        Request.setCount(Request.getCount() + 1);
        this.randURL = randURL;
        super.randUUID = randUUID;
    }


    public String toString() {
        return super.toString() + '\n' +
                "Universal Resource Locator (URL): " + randURL;
    }

    public static String count() {
        return String.valueOf(getcounts);
    }
}
