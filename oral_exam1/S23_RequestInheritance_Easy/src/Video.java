public class Video {
    private String randURL;
    private String randVideoTitle;
    private String randName;

    public Video(String randURL, String randVideoTitle, String randName) {
        this.randURL = randURL;
        this.randVideoTitle = randVideoTitle;
        this.randName = randName;
    }

    @Override
    public String toString() {
        return "Universal Resource Locator (URL): " + randURL + '\n' +
                "Video: " + randVideoTitle + '\n' +
                "By: " + randName;
    }
}
