import java.util.UUID;

public class PostEncryptedFormRequest extends Request {
    private static int encryptedformcount;
    private UUID randUUID;
    private String randIP, randEncryptionScheme;
    private Form randForm;

    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptionScheme) {
        encryptedformcount++;
        PostFormRequest.setPostformcount(PostFormRequest.getPostformcount() + 1);
        PostRequest.setPostcounts(PostRequest.getPostcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randEncryptionScheme = randEncryptionScheme;
        this.randForm = randForm;
        this.randIP = randIP;
        this.randUUID = randUUID;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' +
                "Post request to server with IP address: " + randIP + '\n' +
                "Form Data" + '\n' +
                randForm +
                "This form was encrypted using" + randEncryptionScheme;
    }

    public static String count() {
        return String.valueOf(encryptedformcount);
    }
}
