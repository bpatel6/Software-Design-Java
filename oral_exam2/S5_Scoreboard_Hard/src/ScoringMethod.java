public class ScoringMethod extends Game{
    private String Method;
    private int MethodPoints;

    public ScoringMethod(String method, int methodpoints) {
        this.Method = method;
        this.MethodPoints = methodpoints;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public int getMethodPoints() {
        return MethodPoints;
    }

    public void setMethodPoints(int methodPoints) {
        MethodPoints = methodPoints;
    }
}
