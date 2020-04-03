public class ScoringMethod extends Game{
    private String Method;
    private int MethodPoints;

    public ScoringMethod(String method, int methodpoints) {
        this.Method = method;
        this.MethodPoints = methodpoints;
    }

    public int getMethodPoints() {
        return MethodPoints;
    }

    public String toString() {
        return Method;
    }
}
