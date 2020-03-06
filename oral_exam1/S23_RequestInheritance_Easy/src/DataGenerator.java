
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * The class to generate random data for various other class
 * @see DataGenerator
 */
class DataGenerator {
    // fields to hold example data
    /**
     * rand - stores random integer generated
     */
    private Random rand;
    /**
     * names - stores names
     */
    private String[] names;
    /**
     * encryption - stores encryption schemes
     */
    private String[] encryption;
    /**
     * videoTitles - stores video Title
     */
    private String[] videoTitles;
    /**
     * filePaths - stores file path
     */
    private String[] filePaths;
    /**
     * fileTypes - stores file type
     */
    private String[] fileTypes;
    /**
     * colors - stores colors
     */
    private String[] colors;

    // Constructor

    /**
     * Default constructor initialize rand, names, encryption, videoTitles, filePaths, fileTypes, colors
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    // private utilities for data generation

    /**
     * Selects the random name from the names[]
     * @return String - random name from the names[]
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * Selects the random color from the colors[]
     * @return String - random color from the colors[]
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * Selects the random video title from the videoTitles[]
     * @return String - random video title from the videoTitles[]
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * Selects the random filetype from the fileTypes[]
     * @return String - random filetype from the fileTypes[]
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * Selects the random filepath from the filePaths[]
     * @return String - random filepath from the filePaths[]
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    // public data generation tools
    /**
     * Generates random URL
     * @return String - random URL
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * Generates random payment
     * @return String - random payment
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * Generates random UUID
     * @return String - random UUID
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * Selects the random EncryptionScheme from the encryption[]
     * @return String - random EncryptionScheme from the encryption[]
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * Generates the random Video
     * @return Video - random Video
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * Generates the random file
     * @return File - random file
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * Generates the random form
     * @return Form - random form
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * Generates random IP
     * @return String - random IP
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }
}