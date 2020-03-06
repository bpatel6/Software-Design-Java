
import java.util.UUID;

/**
 * The class to access FileRequest data
 * @see GetFileRequest
 */
public class GetFileRequest extends Request {
    /**
     * filecount - to keep track of all file requests
     */
    private static int filecount;
    /**
     * randFile - to save randFile generated
     */
    private File randFile;

    /**
     * Constructor with randUUID and randFile initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randFile File - to be initialize with an object
     */
    public GetFileRequest(UUID randUUID, File randFile) {
        filecount++;
        GetRequest.setGetcounts(GetRequest.getGetcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randFile = randFile;
        super.randUUID = randUUID;
    }

    /**
     * Prints Object address, UUID and File info
     * @return String with object address, UUID and File info
     */
    @Override
    public String toString() {
        return super.toString() +
                '\n' + randFile;
    }


    /**
     * to access the value of filecount
     * @return integer - filecount var. value
     */
    public static int count() {
        return filecount;
    }
}
