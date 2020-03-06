import java.util.UUID;

/**
 * The class to access VideoRequest data
 * @see GetVideoRequest
 */
public class GetVideoRequest extends Request {
    /**
     * videocount - to keep track of all video requests
     */
    private static int videocount;
    /**
     * randVideo - to save randVideo generated
     */
    private Video randVideo;

    /**
     * Constructor with randUUID and randVideo initialization
     * @param randUUID UUID - to be initialized with an object
     * @param randVideo Video - to be initialized with an object
     */
    public GetVideoRequest(UUID randUUID, Video randVideo) {
        videocount++;
        GetRequest.setGetcounts(GetRequest.getGetcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        super.randUUID = randUUID;
        this.randVideo = randVideo;
    }

    /**
     * Prints Object address, UUID and Video info
     * @return String with object address, UUID and Video info
     */
    @Override
    public String toString() {
        return super.toString() + '\n' + randVideo;
    }

    /**
     * to access the value of videocount
     * @return integer - videocount var. value
     */
    public static int count() {
        return videocount;
    }
}
