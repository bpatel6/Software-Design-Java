import java.util.UUID;

/**
 * The class to present PostFormRequest data
 * @see PostFormRequest
 */
public class PostFormRequest extends PostRequest {
    /**
     * postformcount - to keep track of all post form requests
     */
    private static int postformcount;
    /**
     * randForm - to keep track of post forms
     */
    protected Form randForm;

    /**
     * Default constructor
     */
    public PostFormRequest() {

    }

    /**
     * to access the value of postformcount var.
     * @return integer - postformcount var. value
     */
    public static int getPostformcount() {
        return postformcount;
    }

    /**
     * to set the value of postformcount var.
     * @param postformcount integer - to be set to the postformcount var.
     */
    public static void setPostformcount(int postformcount) {
        PostFormRequest.postformcount = postformcount;
    }

    /**
     * Constructor with randUUID, randIP and Form initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randIP IP - to be initialized with an object
     * @param randForm Form - to be initialized with an object
     */
    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        super();
        postformcount++;
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        super.randUUID = randUUID;
        super.randIP = randIP;
        this.randForm = randForm;
    }

    /**
     * Prints Object address, UUID, IP  and Form info
     * @return String with object address, UUID, IP and Form info
     */
    @Override
    public String toString() {
        return super.toString() +  '\n' +
                randForm;
    }

    /**
     * to access the value of postformcount
     * @return integer - postformcount var. value
     */
    public static int count() {
        return postformcount;
    }
}
