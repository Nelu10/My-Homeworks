package Week8Homework;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void testMain(){
        Athlete athlete1 = new Athlete(11, "John", "SK", "40:10", "xooxo", "xxxox", "xxooo");
        Athlete athlete2 = new Athlete(10, "Emily", "US", "39:45", "xoxox", "xooxo", "xxxxx");
        Athlete athlete3 = new Athlete(12, "Luca", "IT", "41:23", "xxoxo", "xoxox", "oooxo");
        AthletesRanking athletesRanking = new AthletesRanking();
        AthleteRankingComparator athleteRankingComparator = new AthleteRankingComparator();
        athleteRankingComparator.compare(athlete1, athlete2);
        athletesRanking.addAthlete(athlete1);
        athletesRanking.addAthlete(athlete2);
        athletesRanking.addAthlete(athlete3);
        athletesRanking.displayRankings();
    }
}