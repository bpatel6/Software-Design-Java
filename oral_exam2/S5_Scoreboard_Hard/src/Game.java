
/**
 * @see Game
 */

public class Game {
    private static Team Home;
    private static Team Away;
    private static ScoringMethod[] methods;
    private static Team[] teams;

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

    public void getScoringMethod(){
        if (this instanceof Football){
            methods = Football.getFootballMethod();
        }
        else if (this instanceof Basketball){
            methods = Basketball.getBasketballMethods();
        }
        else if (this instanceof Soccer){
            methods = Soccer.getSoccerMethods();
        }
        else {
            methods = Hockey.getHockeyMethods();
        }
        teams = new Team[methods.length];
        for (int i = 0; i < methods.length; i++){
            if (i < methods.length/2){
                teams[i] = Home;
            }
            else {
                teams[i] = Away;
            }
        }
    }

    public void printMethods(){
            for (int i = 0; i < methods.length; i++) {
                System.out.println((i + 1) + " " + teams[i].toString() + " " + methods[i].toString());
            }
    }

    public static void addScoreHelper(ScoringMethod score, Team team){
        team.setScore(team.getScore() + score.getMethodPoints());
    }

    public static void addScore(int index) {
        if ((index-1 > methods.length-1) || (index-1 < 0)){
            throw new IndexOutOfBoundsException("Option is not valid");
        }
        addScoreHelper(methods[index-1],teams[index-1]);
    }
}
