import java.util.HashMap;

/**
 * The class to present Form data
 * @see Form
 */
public class Form {
    /**
     * fields - map to store a label and value
     */
    private HashMap<String, String> fields;

    /**
     * Constructor with fields
     * @param fields Map with a key and value
     */
    public Form(HashMap<String, String> fields) {
        this.fields = fields;
    }

    /**
     * Prints Label-key and value-key's data from field
     * @return String with key and value
     */
    @Override
    public String toString() {
        return "Label: Favorite color " + '\n' +
                "Value: " + fields.get("Favorite color") + '\n' +
                "Label: Favorite encryption scheme " + '\n' +
                "Value: " + fields.get("Favorite encryption scheme") + '\n' +
                "Label: Name " + '\n' +
                "Value: " + fields.get("Name") + '\n';
    }
}
