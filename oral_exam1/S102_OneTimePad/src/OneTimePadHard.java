import java.util.Random;

public class OneTimePadHard{
    private int[] array;
    Random rand = new Random();
    public void keyGenerator(int n){
        array = new int[n];
        for (int i = 0; i < array.length; i++){
            int random_n = rand.nextInt(25);
            array[i] = random_n;
            System.out.print(array[i] + " ");
        }
    }
}
