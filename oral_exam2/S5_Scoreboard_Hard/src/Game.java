
/**
 * Main class of Scoreboard
 * @see Game
 */
public class Game {
    /**
     * Stores the Home team
     */
    private static Team Home;
    /**
     * Stores the Away team
     */
    private static Team Away;
    /**
     * Stores the scoring methods of the game
     */
    private static ScoringMethod[] methods;
    /**
     * Stores the teams of the game
     */
    private static Team[] teams;
    /**
     * Stores the quarter of the game
     */
    private int quarters;
    /**
     * Stores the period of the game
     */
    private int period;

    /**
     * Default game constructor
     */
    public Game(){
    }

    /**
     * Access the Home and Away Team
     * @return Home + Away team names
     */
    public String getTeams(){
        return "Home:" + getHome() + "\n" + "Away:" + getAway();
    }

    /**
     * Access the score of the Home and Away Team
     * @return Score of the both team
     */
    public String getScores(){
        return getHome() + ": " + Home.getScore() + " " + getAway() + ": " + Away.getScore();
    }

    /**
     * Access the Team object home
     * @return Home
     */
    public static Team getHome() {
        return Home;
    }

    /**
     * Sets the Team object home
     * @param home - home team
     */
    public static void setHome(Team home) {
        Home = home;
    }

    /**
     * Access the Team object away
     * @return Away
     */
    public static Team getAway() {
        return Away;
    }

    /**
     * Sets the Team object away
     * @param away - away team
     */
    public static void setAway(Team away) {
        Away = away;
    }

    /**
     * Access the method for scoring based on the instance of the Game
     */
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

    /**
     * Prints the scoring method of the game for Interface
     */
    public void printMethods(){
            for (int i = 0; i < methods.length; i++) {
                System.out.println((i + 1) + " " + teams[i].toString() + " " + methods[i].toString());
            }
    }

    /**
     * Helper function to addscore in the game
     * @param score - scoring method
     * @param team - team
     */
    public void addScoreHelper(ScoringMethod score, Team team){
        team.setScore(team.getScore() + score.getMethodPoints());
    }

    /**
     * Add score based on the chosen option from the interface
     * @param index - chosen option from the game interface
     */
    public void addScore(int index) {
        if ((index-1 > methods.length-1) || (index-1 < 0)){
            throw new IndexOutOfBoundsException("Option is not valid");
        }
        addScoreHelper(methods[index-1],teams[index-1]);
    }

    /**
     * Start the game and initialize the quarter/period and scores to 0
     */
    public void startGame(){
        Home.setScore(0);
        Away.setScore(0);
        quarters = 0;
        period = 0;
    }

    /**
     * End the current period of the game, and increments the quarter/period
     */
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

    /**
     * Give the name of the period or the quarter
     * @param i - current period/quarter
     * @return name of the specific period/quarter
     */
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

    /**
     * Access the current period in the Game
     * @return current period/quarter
     */
    public int getCurrentPeriod(){
        if ((this instanceof Soccer) || (this instanceof Basketball) || (this instanceof Football)){
            return quarters + 1;
        }
        return period + 1;
    }

    /**
     * Checks if the game is over
     * @return true/false based on the quarter and declares the winner
     */
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

    /**
     * Helper function to add additional option to the interface
     * @return integer - index for interface
     */
    public int endQuarterHelper(){
        return methods.length + 1;
    }
}
