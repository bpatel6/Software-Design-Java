import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) throws Exception {
        Scanner input  = new Scanner(System.in);
        System.out.println("Select the type of game:");
        System.out.println("1: Football \n2: Soccer\n3: Basketball\n4: Hockey");
        System.out.println("Enter choice:");
        int gameselected = input.nextInt();
        System.out.println("Enter Home Team:");
        String home = input.next();
        System.out.println("Enter Away Team");
        String away = input.next();
        Game first_game = null;
        if (gameselected == 1){
            first_game = new Football(new Team(home), new Team(away));
        }
        else if (gameselected == 2){
            first_game = new Soccer(new Team(home), new Team(away));
        }
        else if (gameselected == 3){
            first_game = new Basketball(new Team(home), new Team(away));
        }
        else if (gameselected == 4){
            first_game = new Hockey(new Team(home), new Team(away));
        }
        assert first_game != null;
        boolean game = true;
        System.out.println(first_game.getTeams());
        while (game != false) {
            System.out.println(first_game.getScores());
            first_game.getScoringMethod();
            first_game.printMethods();
            System.out.println("Choose Option: ");
            int option = input.nextInt();
            first_game.addScore(option);
        }
    }
}
