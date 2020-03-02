
import java.util.UUID;

public class GetFileRequest extends Request {
    private static int filecount;
    private UUID randUUID;
    private File randFile;

    public static int getFilecount() {
        return filecount;
    }

    public static void setFilecount(int filecount) {
        GetFileRequest.filecount = filecount;
    }

    public GetFileRequest(UUID randUUID, File randFile) {
        filecount++;
        GetRequest.setGetcounts(GetRequest.getGetcounts() + 1);
        Request.setCount(Request.getCount() + 1);
        this.randFile = randFile;
        this.randUUID = randUUID;
    }



    @Override
    public String toString() {
        return  "UUID: " + randUUID +
                 '\n' + randFile;
    }

    public static String count(){
        return String.valueOf(filecount);
    }
}
