import java.util.UUID;

/**
 * The class to access Request data
 * @see GetRequest
 */
public class GetRequest extends Request {
    /**
     * getcounts - to keep track of get requests
     */
    private static int getcounts;
    /**
     * randURL = to save random generated URL
     */
    private String randURL;

    /**
     * to access the value of getcounts var.
     * @return Integer - getcounts var. value
     */
    public static int getGetcounts() {
        return getcounts;
    }

    /**
     * to set the value of getcounts var.
     * @param getcounts Integer - to be set to the getcounts var.
     */
    public static void setGetcounts(int getcounts) {
        GetRequest.getcounts = getcounts;
    }

    /**
     * Constructor with randUUID and randURL initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randURL URL - to be initialized with an object
     */
    public GetRequest(UUID randUUID, String randURL) {
        getcounts++;
        Request.setCount(Request.getCount() + 1);
        this.randURL = randURL;
        super.randUUID = randUUID;
    }


    /**
     * Prints Object address, UUID and URL info
     * @return String with object address, UUID and URL info
     */
    public String toString() {
        return super.toString() + '\n' +
                "Universal Resource Locator (URL): " + randURL;
    }

    /**
     * to access the value of getcounts
     * @return integer - getcounts var. value
     */
    public static int count() {
        return getcounts;
    }
}
