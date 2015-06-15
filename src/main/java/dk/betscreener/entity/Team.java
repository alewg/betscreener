package dk.betscreener.entity;

/**
 * Created by Alexander on 15/06/15.
 */
public class Team {

    private int rank;
    private String name;
    private int points;
    private int matchesOver2point5Goals;
    private int cleanSheets;
    private int failedToScore;

    private HomeStats homeStats;
    private AwayStats awayStats;


    private Team(int rank, String name, int points, int matchesOver2point5Goals, int cleanSheets, int failedToScore, HomeStats homeStats, AwayStats awayStats) {

        this.rank = rank;
        this.name = name;
        this.points = points;
        this.matchesOver2point5Goals = matchesOver2point5Goals;
        this.cleanSheets = cleanSheets;
        this.failedToScore = failedToScore;
        this.homeStats = homeStats;
        this.awayStats = awayStats;

    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchesOver2point5Goals() {
        return matchesOver2point5Goals;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public int getFailedToScore() {
        return failedToScore;
    }

    public HomeStats getHomeStats() {
        return homeStats;
    }

    public AwayStats getAwayStats() {
        return awayStats;
    }

    public static class Builder {

        private int rank;
        private String name;
        private int points;
        private int matchesOver2point5Goals;
        private int cleanSheets;
        private int failedToScore;

        private HomeStats homeStats;
        private AwayStats awayStats;

        public Builder() {
        }

        public Builder rank(int rank) {
            this.rank = rank;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder points(int points) {
            this.points = points;
            return this;
        }

        public Builder matchesOver2point5Goals(int points) {
            this.matchesOver2point5Goals = points;
            return this;
        }

        public Builder cleanSheets(int cleanSheets) {
            this.cleanSheets = cleanSheets;
            return this;
        }

        public Builder failedToScore(int failedToScore) {
            this.failedToScore = failedToScore;
            return this;
        }

        public Builder homeStats(HomeStats homeStats) {
            this.homeStats = homeStats;
            return this;
        }

        public Builder awayStats(AwayStats awayStats) {
            this.awayStats = awayStats;
            return this;
        }

        public Team build() {
            return new Team(rank, name, points, matchesOver2point5Goals, cleanSheets, failedToScore, homeStats, awayStats);
        }

    }

}
