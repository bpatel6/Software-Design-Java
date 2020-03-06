/**
 * The class to present Video data
 */
public class Video {
    /**
     * randURL - to store a random URL
     */
    private String randURL;
    /**
     * randVideoTitle - to store a random Video title
     */
    private String randVideoTitle;
    /**
     * randName - to store a random name
     */
    private String randName;

    /**
     * Constructor with randURL, randVideoTitle and randName initialization
     * @param randURL URL - random URL
     * @param randVideoTitle VideoTitle - random VideoTitle
     * @param randName Name - random Name
     */
    public Video(String randURL, String randVideoTitle, String randName) {
        this.randURL = randURL;
        this.randVideoTitle = randVideoTitle;
        this.randName = randName;
    }

    /**
     * Prints randURL, randVideoTitle and randName
     * @return String with randURl, randVideoTitle and randName
     */
    @Override
    public String toString() {
        return "Universal Resource Locator (URL): " + randURL + '\n' +
                "Video: " + randVideoTitle + '\n' +
                "By: " + randName;
    }
}
