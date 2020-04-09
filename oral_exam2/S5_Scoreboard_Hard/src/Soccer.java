/**
 * The class to represent Soccer scoring methods
 * @see Soccer
 */
public class Soccer extends Game {
    /**
     * Stores the Soccer scoring methods
     */
    private static final ScoringMethod[] SoccerMethods = new ScoringMethod[2];

    /**
     * Constructor to initialize teams and scoring methods
     * @param home - home team
     * @param away - away team
     */
    public Soccer(Team home, Team away){
        Game.setHome(home);
        Game.setAway(away);
        SoccerMethods[0] = new ScoringMethod("Goal", 1);
        SoccerMethods[1] = new ScoringMethod("Penalty Shot", 1);
    }

    /**
     * Access the soccer methods
     * @return array of all soccer methods
     */
    public static ScoringMethod[] getSoccerMethods(){
        ScoringMethod[] GameSoccerMethods = new ScoringMethod[SoccerMethods.length * 2];
        for (int i = 0; i < SoccerMethods.length; i++){
            GameSoccerMethods[i] = SoccerMethods[i];
            GameSoccerMethods[i+SoccerMethods.length] = SoccerMethods[i];
        }
        return GameSoccerMethods;
    }
}
