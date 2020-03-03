public class File {
    private String randFilePath, randFileType;

    public File(String randFilePath, String randFileType) {
        this.randFileType = randFileType;
        this.randFilePath = randFilePath;
    }

    @Override
    public String toString() {
        return "Universal Resource Locator (URL): " + "file://" +
                randFilePath + '.' + randFileType + '\n' +
                "File Path: " + randFilePath + '\n' +
                "File Type: " + randFileType;
    }
}
