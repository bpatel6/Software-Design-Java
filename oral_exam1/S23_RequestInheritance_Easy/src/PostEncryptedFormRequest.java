import java.util.UUID;

public class PostEncryptedFormRequest extends PostFormRequest {
    private static int encryptedformcount;
    private UUID randUUID;
    private String randIP, randEncryptionScheme;
    private Form randForm;

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

    @Override
    public String toString() {
        return super.toString() + 
                "This form was encrypted using" + randEncryptionScheme;
    }

    public static String count() {
        return String.valueOf(encryptedformcount);
    }
}
