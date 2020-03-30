public class Hockey extends Game {
    private static final ScoringMethod[] HockeyMethods = new ScoringMethod[2];
    public Hockey(Team home, Team away){
        Game.setHome(home);
        Game.setAway(away);
        HockeyMethods[0] = new ScoringMethod("Goal", 1);
        HockeyMethods[1] = new ScoringMethod("Penalty Shot",1);
    }

    public static ScoringMethod[] getHockeyMethods(){
        ScoringMethod[] GameHockeyMethods = new ScoringMethod[HockeyMethods.length *2];
        for (int i = 0; i < HockeyMethods.length; i++){
            GameHockeyMethods[i] = HockeyMethods[i];
            GameHockeyMethods[i+HockeyMethods.length] = HockeyMethods[i];
        }
        return GameHockeyMethods;
    }
}
