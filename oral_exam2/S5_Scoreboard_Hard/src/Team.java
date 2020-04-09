/**
 * The class to store team name and score
 * @see Team
 */
public class Team extends Game {
    /**
     * Stores the Team name
     */
    private String TeamName;
    /**
     * Stores the Team score
     */
    private int Score;

    /**
     * Constructor to initialize team object
     * @param Teamname - team name
     */
    public Team(String Teamname){
        TeamName = Teamname;
        Score = 0;
    }

    @Override
    /**
     * Prints the team name
     */
    public String toString() {
        return TeamName;
    }

    /**
     * Access the score of the team
     * @return Score
     */
    public int getScore() {
        return Score;
    }

    /**
     * Sets the score of the team
     * @param score - score to be set
     */
    public void setScore(int score) {
        Score = score;
    }
}
