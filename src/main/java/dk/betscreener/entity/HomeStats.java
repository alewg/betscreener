package dk.betscreener.entity;

/**
 * Created by Alexander on 15/06/15.
 */
public class HomeStats {

    private int matchesWonHome;
    private int matchesDrawHome;
    private int matchesLostHome;
    private int goalsScoredHome;
    private int goalsConcededHome;

    public HomeStats(int matchesWonHome, int matchesDrawHome, int matchesLostHome, int goalsScoredHome, int goalsConcededHome) {
        this.matchesWonHome = matchesWonHome;
        this.matchesDrawHome = matchesDrawHome;
        this.matchesLostHome = matchesLostHome;
        this.goalsScoredHome = goalsScoredHome;
        this.goalsConcededHome = goalsConcededHome;
    }

    public int getMatchesWonHome() {
        return matchesWonHome;
    }

    public int getMatchesDrawHome() {
        return matchesDrawHome;
    }

    public int getMatchesLostHome() {
        return matchesLostHome;
    }

    public int getGoalsScoredHome() {
        return goalsScoredHome;
    }

    public int getGoalsConcededHome() {
        return goalsConcededHome;
    }
}
