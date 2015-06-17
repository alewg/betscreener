package dk.betscreener.statistic;

import dk.betscreener.entity.AwayStats;
import dk.betscreener.entity.HomeStats;
import dk.betscreener.entity.League;
import dk.betscreener.entity.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 15/06/15.
 */
public class Statistic {

    /**
     * The Url except the league
     */
    private String target;

    /**
     * Target is the Url except for the league
     *
     * ie. http://www.soccerstats.com/widetable.asp?league=
     *
     * @param target
     */
    public Statistic(String tmpFolder, String target) {
        this.target = target;
    }

    /**
     * Download league webpage to temporary folder
     *
     * @param league
     */
    private String download(String league) {

        try {
            Document document = Jsoup.connect(target + league).get();

            Elements elements = document.getElementsByClass("trow3");

            return elements.text();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Retrieve statistics about league based on leagueNames
     *
     * @param leagueNames
     */
    public List<League> retrieveStatistics(List<String> leagueNames) {

        List<League> leagueData = new ArrayList<>();

        for(String leagueName : leagueNames) {

            //Downloads a league
            String data = download(leagueName);

            List<Team> teams = new ArrayList<>();

            //Split the league data into an array
            String[] dataArr = data.split(" ");

            //Cleaning up the league array to only contain pretty data
            for (int i = 0; i < dataArr.length; i++) {
                dataArr[i] = dataArr[i].replaceAll("\\W", "");
            }

            //Looping through data array to get the data in the array
            for (int i = 0; i < dataArr.length; i++) {

                int rank;

                try {
                    rank = Integer.parseInt(dataArr[i]);
                    System.out.println("Rank: " + rank);
                } catch (NumberFormatException nfe) {
                    break;
                }

                StringBuilder sb = new StringBuilder();

                int nameLength = 0;

                while(dataArr[i+1+nameLength].matches("\\D+")) {
                    sb.append(dataArr[i+1+nameLength] + " ");
                    nameLength++;
                }

                System.out.println("Team name: " + sb.toString());

                //Home statistics
                int homeWon = Integer.parseInt(dataArr[i+nameLength+9]);
                System.out.println("Home games won: " + homeWon);

                int homeDraw = Integer.parseInt(dataArr[i+nameLength+10]);
                System.out.println("Home games draw: " + homeDraw);

                int homeLost = Integer.parseInt(dataArr[i+nameLength+11]);
                System.out.println("Home games Lost: " + homeLost);

                int homeGoalsScored = Integer.parseInt(dataArr[i+nameLength+12]);
                System.out.println("Home goals scored: " + homeGoalsScored);

                int homeGoalsConceded = Integer.parseInt(dataArr[i+nameLength+13]);
                System.out.println("Home goals conceded: " + homeGoalsConceded);

                HomeStats homeStats = new HomeStats(homeWon,homeDraw,homeLost,homeGoalsScored,homeGoalsConceded);

                //Away statistics
                int awayWon = Integer.parseInt(dataArr[i+nameLength+14]);
                System.out.println("Away games won: " + awayWon);

                int awayDraw = Integer.parseInt(dataArr[i+nameLength+15]);
                System.out.println("Away games draw: " + awayDraw);

                int awayLost = Integer.parseInt(dataArr[i+nameLength+16]);
                System.out.println("Away games lost: " + awayLost);

                int awayGoalsScored = Integer.parseInt(dataArr[i+nameLength+17]);
                System.out.println("Away goals scored: " + awayGoalsScored);

                int awayGoalsConceded = Integer.parseInt(dataArr[i+nameLength+18]);
                System.out.println("Away goals conceded: " + awayGoalsConceded);

                AwayStats awayStats = new AwayStats(awayWon,awayDraw,awayLost,awayGoalsScored,awayGoalsConceded);


                Team team = new Team.Builder()
                        .rank(rank)
                        .name(sb.toString())
                        .homeStats(homeStats)
                        .awayStats(awayStats)
                        .build();

                teams.add(team);

                i+=nameLength+23;

            }

            leagueData.add(new League(leagueName, teams));
            System.out.println(teams.size());

        }

        return leagueData;

    }


}
