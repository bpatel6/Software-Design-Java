import java.util.UUID;

/**
 * The class to present PostEncryptedFormRequest data
 */
public class PostEncryptedFormRequest extends PostFormRequest {
    /**
     * encryptedformcount - to keep track of all post encrypted form requests
     */
    private static int encryptedformcount;
    /**
     * randEncryptionScheme - to keep track of encryption scheme
     */
    private String randEncryptionScheme;

    /**
     * Constructor with randUUID, randIP, randForm and randEncryptionScheme initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randIP IP - to be initialized with an object
     * @param randForm Form - to be initialized with an object
     * @param randEncryptionScheme EcnyptionScheme - to be initialized with an object
     */
    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptionScheme) {
        super();
        encryptedformcount++;
        PostFormRequest.setPostformcount(PostFormRequest.getPostformcount() + 1);
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randEncryptionScheme = randEncryptionScheme;
        super.randForm = randForm;
        super.randIP = randIP;
        super.randUUID = randUUID;
    }

    /**
     * Prints object address, UUID, IP, Form and encryptionScheme info
     * @return String with object address, UUID, IP, Form and encryptionScheme info
     */
    @Override
    public String toString() {
        return super.toString() + 
                "This form was encrypted using: " + randEncryptionScheme;
    }

    /**
     * to access the value of encryptedformcount
     * @return integer - encryptedformcount var. value
     */
    public static int count() {
        return encryptedformcount;
    }
}
