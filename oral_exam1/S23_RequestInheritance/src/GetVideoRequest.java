import java.util.UUID;

public class GetVideoRequest extends Request {
    private static int videocount;
    private UUID randUUID;
    private Video randVideo;

    public static int getVideocount() {
        return videocount;
    }

    public static void setVideocount(int videocount) {
        GetVideoRequest.videocount = videocount;
    }

    public GetVideoRequest(UUID randUUID, Video randVideo) {
        videocount++;
        GetRequest.setGetcounts(GetRequest.getGetcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randUUID = randUUID;
        this.randVideo = randVideo;
    }

    @Override
    public String toString() {
        return "UUID: " + randUUID + '\n' + randVideo;
    }

    public static String count(){
        return String.valueOf(videocount);
    }
}
