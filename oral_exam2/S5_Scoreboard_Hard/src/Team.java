public class Team extends Game {
    private String TeamName;
    private int Score;

    public Team(String Teamname){
        TeamName = Teamname;
        Score = 0;
    }

    @Override
    public String toString() {
        return TeamName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
