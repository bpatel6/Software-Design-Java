import java.io.FileNotFoundException;

public class GraphAlgorithmTest {
    public static void main(String[] args) throws FileNotFoundException {
        GraphAlgorithm.readFile();
        GraphAlgorithm.findEdges();
        GraphAlgorithm.zeroVertices();
        GraphAlgorithm.averageVertices();
        GraphAlgorithm.hasMostVertices();
    }
}
