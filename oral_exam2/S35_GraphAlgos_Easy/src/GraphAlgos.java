import java.io.*;

public class GraphAlgos {
    private static String [] words;
    private static int [] connections = new int[5757];
    public static void readFile() throws FileNotFoundException {
        words = new String[5757];
        BufferedReader reader;
       try{
           reader = new BufferedReader(new FileReader(GraphAlgos.class.getResource("words.dat").getFile()));
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

    public static void zeroVertices(){
        int zerovertices = 0;
        StringBuilder adjecent;
       for (int i = 0; i < words.length; i++){
           adjecent = new StringBuilder();
           for(int j = 0; j < words.length; j++){
               if (checkRelation(words[i], words[j])){
                   adjecent.append(words[j]).append(", ");
                    connections[i] = connections[i] + 1;
               }
           }
           if (connections[i] != 0){
               System.out.println(words[i] + " adjacent to " + adjecent.deleteCharAt(adjecent.length()-2));
           }
       }
       for (int i = 0; i < connections.length; i++){
           if (connections[i] == 0){
               zerovertices++;
           }
       }
      System.out.println(zerovertices);
    }

    public static int averageVertices(){
        int total = 0;
        for(int i = 0; i < connections.length; i++){
            total += connections[i];
        }
        return total/5757;
    }

    public static void hasMostVertices(){
        System.out.println("Word that has the most vertices");
        for (int i = 0; i < connections.length; i++){
            if (connections[i] > averageVertices()){
                System.out.println(words[i] + " " + connections[i]);
            }
        }
    }


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
