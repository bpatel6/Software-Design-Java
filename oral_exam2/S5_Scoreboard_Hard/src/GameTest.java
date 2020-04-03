import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
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
        System.out.println(first_game.getTeams());
        first_game.getScoringMethod();
        first_game.startGame();
        while (!first_game.isGameover()) {
            System.out.println(first_game.getScores());
            System.out.println(first_game.getPeriodName(first_game.getCurrentPeriod()));
            first_game.printMethods();
            System.out.println(first_game.endQuarterHelper() + " " + "End Quarter");
            System.out.println("Choose Option: ");
            int option = input.nextInt();
            if (option == first_game.endQuarterHelper()){
                first_game.endCurrentPeriod();
            }
            else {
                first_game.addScore(option);
            }
        }
    }
}
