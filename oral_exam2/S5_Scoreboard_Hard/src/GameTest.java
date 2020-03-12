public class GameTest {
    public static void main(String[] args) {
        Team hawk = new Team("Hawk");
        Team bull = new Team("Bull");
        Game hawkvsbull = new Football(hawk,bull);
        System.out.println(hawkvsbull.getTeams());
        System.out.println(hawkvsbull.getScores());
        ScoringMethod Touchdown = hawkvsbull.getScoringMethod(0);
        ScoringMethod Extrapoint = hawkvsbull.getScoringMethod(3);
        hawkvsbull.addScore(hawk, Touchdown);
        hawkvsbull.addScore(bull, Touchdown);
        hawkvsbull.addScore(hawk,Extrapoint);
        System.out.println(hawkvsbull.getScoringMethod());
        System.out.println(hawkvsbull.getScores());

    }
}
