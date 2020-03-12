

/**
 * @see Game
 */

public class Game {
    private static Team Home;
    private static Team Away;
    public Game(){
    }

    public String getTeams(){
        return "Home:" + getHome() + "\n" + "Away:" + getAway();
    }

    public String getScores(){
        return "ScoreBoard: \n" + getHome() + ": " + Home.getScore() + "\n" + getAway() + ": " + Away.getScore();
    }

    public static Team getHome() {
        return Home;
    }

    public static void setHome(Team home) {
        Home = home;
    }

    public static Team getAway() {
        return Away;
    }

    public static void setAway(Team away) {
        Away = away;
    }

    public ScoringMethod getScoringMethod(int index){
        if (this instanceof Football){
            return Football.getFootballMethod(index);
        }
        return null;
    }

    public String getScoringMethod(){
        if (this instanceof Football){
            return Football.PrintMethods();
        }
        return null;
    }

    public void addScore(Team team, ScoringMethod score){
        team.setScore(team.getScore() + score.getMethodPoints());
    }
}
