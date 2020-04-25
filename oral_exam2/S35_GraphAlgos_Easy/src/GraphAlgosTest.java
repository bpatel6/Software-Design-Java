import java.io.FileNotFoundException;

public class GraphAlgosTest {
    public static void main(String[] args) throws FileNotFoundException {
        GraphAlgos.readFile();
        GraphAlgos.zeroVertices();
        System.out.println(GraphAlgos.averageVertices());
        GraphAlgos.hasMostVertices();
    }
}
