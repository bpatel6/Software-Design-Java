public class Football extends Game {
    private static ScoringMethod[] FootballMethods = new ScoringMethod[4];
    public Football(Team home, Team away){
        Game.setHome(home);
        Game.setAway(away);
        FootballMethods[0] = new ScoringMethod("TouchDown",6);
        FootballMethods[1] = new ScoringMethod("Field Goal", 3);
        FootballMethods[2] = new ScoringMethod("Safety", 2);
        FootballMethods[3] = new ScoringMethod("Extra Point",1);

    }

    public static ScoringMethod getFootballMethod(int index){
        return FootballMethods[index];
    }

    public static String PrintMethods(){
        StringBuilder hometeam = new StringBuilder();
        StringBuilder awayteam = new StringBuilder();
        for (int i = 0; i < FootballMethods.length; i++){
            if (i < FootballMethods.length-1) {
                hometeam.append(Game.getHome() + " " + FootballMethods[i].getMethod()).append('\n');
                awayteam.append(Game.getAway() + " " + FootballMethods[i].getMethod()).append('\n');
            }
            else {
                hometeam.append(Game.getHome() + " " + FootballMethods[i].getMethod());
                awayteam.append(Game.getAway() + " " + FootballMethods[i].getMethod());
            }
        }
        return hometeam + "\n" + awayteam;
    }
}
