import java.io.FileNotFoundException;

/**
 * The class to test out the implementation of graph algorithm easy
 * @see GraphAlgorithmTest
 */
public class GraphAlgorithmTest {
    public static void main(String[] args) {
        GraphAlgorithm.readFile();
        GraphAlgorithm.findEdges();
        GraphAlgorithm.zeroVertices();
        GraphAlgorithm.averageVertices();
        GraphAlgorithm.hasMostVertices();
    }
}
