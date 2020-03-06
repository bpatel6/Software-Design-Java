/**
 * The class to present File data
 * @see File
 */
public class File {
    /**
     * randFilePath - to keep track of file path
     */
    private String randFilePath;
    /**
     * randFileType - to keep track of file type
     */
    private String randFileType;

    /**
     * Constructor with randFilepath and randFileType initialization
     * @param randFilePath String - random filepath
     * @param randFileType String - random filetype
     */
    public File(String randFilePath, String randFileType) {
        this.randFileType = randFileType;
        this.randFilePath = randFilePath;
    }

    /**
     * Prints randfilepath and ranfiletype
     * @return String with filepath and filetype
     */
    @Override
    public String toString() {
        return "Universal Resource Locator (URL): " + "file://" +
                randFilePath + '.' + randFileType + '\n' +
                "File Path: " + randFilePath + '\n' +
                "File Type: " + randFileType;
    }
}
