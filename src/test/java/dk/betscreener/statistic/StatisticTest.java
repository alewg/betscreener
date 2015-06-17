package dk.betscreener.statistic;

import dk.betscreener.entity.AwayStats;
import dk.betscreener.entity.HomeStats;
import dk.betscreener.entity.League;
import dk.betscreener.entity.Team;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 15/06/15.
 */
public class StatisticTest {

    @Test
    public void testDownload() {

        Statistic stats = new Statistic("","http://www.soccerstats.com/widetable.asp?league=");

        List<String> leagueNames = new ArrayList<>();
        leagueNames.add("sweden");

        List<League> leagues = stats.retrieveStatistics(leagueNames);

        System.out.println("Number of leagues: " + leagues.size());

        for(League l : leagues) {

            for(Team t : l.getLeague()) {
                System.out.println("*********************");
                System.out.println(t.getRank());
                System.out.println(t.getName());
                System.out.println("*********************");
            }

        }

   }

    @Test
    @Ignore
    public void testSomething() {

        List<Team> teams = new ArrayList<>();

        String data = "1  IFK Goteborg  13 10 2 1 19 5 +14 32 5 1 1 10 3 5 1 0 9 2 2.46 38% 8 3 31% 2  Elfsborg  13 8 3 2 26 14 +12 27 4 3 0 17 10 4 0 2 9 4 2.08 69% 2 2 69% 3  Norrkoping  13 8 3 2 22 14 +8 27 5 1 1 12 8 3 2 1 10 6 2.08 54% 5 1 54% 4  Malmo FF  13 7 4 2 26 16 +10 25 4 2 1 13 7 3 2 1 13 9 1.92 77% 3 2 69% 5  Djurgarden  13 6 5 2 24 15 +9 23 3 2 1 13 7 3 3 1 11 8 1.77 54% 3 1 77% 6  AIK Stockholm  13 6 5 2 24 17 +7 23 6 1 0 19 8 0 4 2 5 9 1.77 69% 4 3 62% 7  Helsingborg  13 5 3 5 16 15 +1 18 4 1 1 10 3 1 2 4 6 12 1.38 62% 6 3 54% 8  Gefle  13 5 2 6 16 22 -6 17 3 2 1 8 3 2 0 5 8 19 1.31 54% 5 3 54% 9  BK Hacken  13 4 4 5 12 13 -1 16 1 2 3 4 7 3 2 2 8 6 1.23 15% 5 5 31% 10  Kalmar FF  13 4 3 6 15 16 -1 15 3 2 2 9 7 1 1 4 6 9 1.15 54% 2 5 54% 11  Hammarby  13 3 4 6 15 19 -4 13 3 1 2 9 7 0 3 4 6 12 1.00 54% 1 4 62% 12  Falkenbergs  13 3 3 7 16 23 -7 12 2 2 2 8 9 1 1 5 8 14 0.92 46% 4 3 54% 13  GIF Sundsvall  13 3 3 7 13 21 -8 12 0 2 4 3 10 3 1 3 10 11 0.92 38% 0 5 62% 14  Orebro SK  13 2 5 6 10 22 -12 11 2 3 2 7 9 0 2 4 3 13 0.85 46% 2 6 46% 15  Halmstads BK  13 2 3 8 11 21 -10 9 2 0 5 6 12 0 3 3 5 9 0.69 54% 3 4 54% 16  Atvidaberg  13 1 2 10 14 26 -12 5 1 2 3 10 11 0 0 7 4 15 0.38 77% 0 3 77% Home wins:  46% Over 1.5 goals:  79% Draws:  26% Over 2.5 goals:  54% Away wins:  28% Over 3.5 goals:  29% % goals scored after the 80th min.:  15.1%\n";

        String[] dataArr = data.split(" ");

        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = dataArr[i].replaceAll("\\W", "");
        }

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


        System.out.println(teams.size());

    }


}
