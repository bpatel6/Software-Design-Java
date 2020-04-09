/**
 * The class to represent Scoring method
 * @see ScoringMethod
 */
public class ScoringMethod extends Game{
    /**
     * Stores the method name
     */
    private String Method;
    /**
     * Store the method point
     */
    private int MethodPoints;

    /**
     * Constructor to initialize scoringmethod object
     * @param method - name of the method
     * @param methodpoints - points of the method
     */
    public ScoringMethod(String method, int methodpoints) {
        this.Method = method;
        this.MethodPoints = methodpoints;
    }

    /**
     * Access the method point
     * @return MethodPoints
     */
    public int getMethodPoints() {
        return MethodPoints;
    }

    /**
     * Prints the method name
     * @return MethodName
     */
    public String toString() {
        return Method;
    }
}
