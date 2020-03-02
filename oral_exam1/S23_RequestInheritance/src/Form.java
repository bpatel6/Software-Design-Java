import java.util.HashMap;

public class Form {
    private HashMap<String, String> fields;
    public Form(HashMap<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return  "Label: Favorite color " + '\n' +
                "Value: " + fields.get("Favorite color") + '\n' +
                "Label: Favorite encryption scheme " + '\n' +
                "Value: " + fields.get("Favorite encryption scheme") + '\n' +
                "Label: Name " + '\n' +
                "Value: " + fields.get("Name") + '\n';
    }
}
