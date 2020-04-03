
/**
 * @see Game
 */

public class Game {
    private static Team Home;
    private static Team Away;
    private static ScoringMethod[] methods;
    private static Team[] teams;
    private int quarters;
    private int period;

    public Game(){
    }

    public String getTeams(){
        return "Home:" + getHome() + "\n" + "Away:" + getAway();
    }

    public String getScores(){
        return getHome() + ": " + Home.getScore() + " " + getAway() + ": " + Away.getScore();
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

    public void addScoreHelper(ScoringMethod score, Team team){
        team.setScore(team.getScore() + score.getMethodPoints());
    }

    public void addScore(int index) {
        if ((index-1 > methods.length-1) || (index-1 < 0)){
            throw new IndexOutOfBoundsException("Option is not valid");
        }
        addScoreHelper(methods[index-1],teams[index-1]);
    }

    public void startGame(){
        quarters = 0;
        period = 0;
    }

    public void endCurrentPeriod(){
        if (quarters <= 4){
            quarters++;
        }
        if (period <= 3) {
            period++;
        }
        else {
            throw new IllegalArgumentException("Period/Quarter can't be extended further");
        }
    }

    public int getLengthofPeriod(){
        if (this instanceof Hockey){
            return 3;
        }
        else {
            return 4;
        }
    }

    public String getPeriodName(int i){
        if (this instanceof Hockey) {
            if (i == 1 || i == 2) {
                return "Current Period: " + i;
            }
            else {
                return "Current Period: Final";
            }
        }
        else {
            if (i == 1 || i == 3){
                return "Current Quarter: " + i;
            }
            else if (i == 2){
                return "Current Quarter: Half";
            }
            else {
                return "Current Quarter: Final";
            }
        }
    }

    public int getCurrentPeriod(){
        if ((this instanceof Soccer) || (this instanceof Basketball) || (this instanceof Football)){
            return quarters + 1;
        }
        return period + 1;
    }

    public boolean isGameover(){
        if (period == 4 || quarters == 5){
            System.out.println("Game is Over!!");
            System.out.println(getPeriodName(getCurrentPeriod()));
            System.out.println(getScores());
            if (Home.getScore() > Away.getScore()){
                System.out.println("Winner: " + getHome());
            }
            else if (Home.getScore() == Away.getScore()){
                System.out.println("Match Tied!!");
            }
            else {
                System.out.println("Winner: " + getAway());
            }
            return true;
        }
        return false;
    }

    public int endQuarterHelper(){
        return methods.length + 1;
    }
}
