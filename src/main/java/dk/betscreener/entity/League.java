package dk.betscreener.entity;

import java.util.List;

/**
 * Created by Alexander on 18/06/15.
 */
public class League {

    private String name;
    private List<Team> league;

    public League() {
    }

    public League(List<Team> league) {
        this.league = league;
    }

    public League(String name, List<Team> league) {
        this.name = name;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setLeague(List<Team> league) {
        this.league = league;
    }

    public List<Team> getLeague() {
        return league;
    }
}
