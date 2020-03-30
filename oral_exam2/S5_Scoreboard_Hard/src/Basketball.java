public class Basketball extends Game {
    private static final ScoringMethod[] BasketballMethods = new ScoringMethod[3];
    public Basketball(Team home, Team away){
        Game.setHome(home);
        Game.setAway(away);
        BasketballMethods[0] = new ScoringMethod("Three-point shot", 3);
        BasketballMethods[1] = new ScoringMethod("Two-point Shot", 2);
        BasketballMethods[2] = new ScoringMethod("One-point foul shot", 1);
    }

    public static ScoringMethod[] getBasketballMethods(){
        ScoringMethod[] GameBasketballMethods = new ScoringMethod[BasketballMethods.length * 2];
        for (int i = 0; i < BasketballMethods.length; i++){
            GameBasketballMethods[i] = BasketballMethods[i];
            GameBasketballMethods[i+BasketballMethods.length] = BasketballMethods[i];
        }
        return GameBasketballMethods;
    }
}
