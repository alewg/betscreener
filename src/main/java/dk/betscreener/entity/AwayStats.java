package dk.betscreener.entity;

/**
 * Created by Alexander on 15/06/15.
 */
public class AwayStats {

    private int matchesWonAway;
    private int matchesDrawAway;
    private int matchesLostAway;
    private int goalsScoredAway;
    private int goalsConcededAway;


    public AwayStats(int matchesWonAway, int matchesDrawAway, int matchesLostAway, int goalsScoredAway, int goalsConcededAway) {
        this.matchesWonAway = matchesWonAway;
        this.matchesDrawAway = matchesDrawAway;
        this.matchesLostAway = matchesLostAway;
        this.goalsScoredAway = goalsScoredAway;
        this.goalsConcededAway = goalsConcededAway;
    }

    public int getMatchesWonAway() {
        return matchesWonAway;
    }

    public int getMatchesDrawAway() {
        return matchesDrawAway;
    }

    public int getMatchesLostAway() {
        return matchesLostAway;
    }

    public int getGoalsScoredAway() {
        return goalsScoredAway;
    }

    public int getGoalsConcededAway() {
        return goalsConcededAway;
    }
}
