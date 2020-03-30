public class Football extends Game {
    private static final ScoringMethod[] FootballMethods = new ScoringMethod[5];
    public Football(Team home, Team away){
        Game.setHome(home);
        Game.setAway(away);
        FootballMethods[0] = new ScoringMethod("TouchDown",6);
        FootballMethods[1] = new ScoringMethod("Field Goal", 3);
        FootballMethods[2] = new ScoringMethod("Two-Point Conversion", 2);
        FootballMethods[3] = new ScoringMethod("Safety", 2);
        FootballMethods[4] = new ScoringMethod("Extra Point",1);

    }

    public static ScoringMethod[] getFootballMethod(){
        ScoringMethod[] GameFootballMethods = new ScoringMethod[FootballMethods.length * 2];
        for (int i = 0; i < FootballMethods.length; i++){
            GameFootballMethods[i] = FootballMethods[i];
            GameFootballMethods[i+FootballMethods.length] = FootballMethods[i];
        }
        return GameFootballMethods;
    }

}
