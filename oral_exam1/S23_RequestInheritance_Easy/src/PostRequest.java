import java.util.UUID;

/**
 * The class to present PostRequest data
 * @see PostRequest
 */
public class PostRequest extends Request {
    /**
     * randIP - to save randIP generated
     */
    protected String randIP;
    /**
     * postcounts - to keep track of all post requests
     */
    private static int postcounts;

    /**
     * Default constructor
     */
    public PostRequest() {

    }

    /**
     * to access the value of postcounts var.
     * @return integer - postcounts var. value
     */
    public static int getPostcounts() {
        return postcounts;
    }

    /**
     * to set the value of postcounts var.
     * @param postcounts integer - to be set to the postcounts var.
     */
    public static void setPostcounts(int postcounts) {
        PostRequest.postcounts = postcounts;
    }

    /**
     * Constructor with randUUID and randIP initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randIP randIP - to be initialized with an object
     */
    public PostRequest(UUID randUUID, String randIP) {
        postcounts++;
        Request.setCount(Request.getCount() + 1);
        this.randIP = randIP;
        super.randUUID = randUUID;
    }

    /**
     * Prints object address, UUID and IP
     * @return String with object address, UUID and IP
     */
    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Post request to server with IP address: " + randIP;
    }

    /**
     * to access the value of postcounts var.
     * @return integer - postcounts var. value
     */
    public static int count() {
        return postcounts;
    }
}
