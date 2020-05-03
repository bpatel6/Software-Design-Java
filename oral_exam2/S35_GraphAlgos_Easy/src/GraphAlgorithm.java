import java.io.*;

/**
 * The class to find edges, zero vertices, average edge and the vertices with most number of edges
 * @see GraphAlgorithm
 */
public class GraphAlgorithm {
    private static String [] words;
    private static double average;
    private static int [] connections = new int[5757];

    /**
     * Method to read in word file
     */
    public static void readFile() {
        words = new String[5757];
        BufferedReader reader;
       try{
           reader = new BufferedReader(new FileReader(GraphAlgorithm.class.getResource("words.dat").getFile()));
           String line = reader.readLine();
           words[0] = line;
           int i = 1;
           while(i != 5757){
               //System.out.println(words[i-1]);
               line = reader.readLine();
               words[i] = line;
               i++;
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    /**
     * Method to find the edges to all vertices
     */
    public static void findEdges(){
        StringBuilder adjacent;
       for (int i = 0; i < words.length; i++){
           adjacent = new StringBuilder();
           for(int j = 0; j < words.length; j++){
               if (checkRelation(words[i], words[j])){
                   adjacent.append(words[j]).append(", ");
                    connections[i] = connections[i] + 1;
               }
           }
           /*if (connections[i] != 0){
               System.out.println(words[i] + " adjacent to " + adjacent.deleteCharAt(adjacent.length()-2));
           }*/
       }
    }

    /**
     * Method to find the zero edge vertices
     */
    public static void zeroEdgeVertices(){
        int zeroVertices = 0;
        for (int i = 0; i < connections.length; i++){
            if (connections[i] == 0){
                zeroVertices++;
            }
        }
        System.out.println("--------------------------------");
        System.out.println("Number of vertices with 0 edge: " + zeroVertices);
    }

    /**
     * Method to compute average number of edges
     */
    public static void averageEdge(){
        double total = 0;
        for(int i = 0; i < connections.length; i++){
            total += connections[i];
        }
        average = total/5757;
        System.out.println("-------------------------------------");
        System.out.println("Average number of Edge vertices has: " + average);
    }

    /**
     * Method to find the vertices that has most number of edges
     */
    public static void hasMostEdges(){
        System.out.println("--------------------------------");
        System.out.println("Words that has the most vertices:");
        for (int i = 0; i < connections.length; i++){
            if (connections[i] == 25){
                System.out.println(words[i] + " " + connections[i]);
            }
        }
    }

    /**
     * Algorithm that check if two vertices are related or not
     * @param word1 first vertices
     * @param word2 second vertices
     * @return true/false = related/not-related
     */
    public static boolean checkRelation(String word1, String word2){
        int difference = 0;
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)){
                    difference++;
                }
            }
            return difference == 1;
        }
            return false;
    }
}
