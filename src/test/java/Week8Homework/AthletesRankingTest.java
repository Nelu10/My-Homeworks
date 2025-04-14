package Week8Homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthletesRankingTest {
    AthletesRanking athletes = new AthletesRanking();
    Athlete athlete1 = new Athlete(11, "John", "SK", "40:10", "xooxo", "xxxox", "xxooo");

    @Test
    void testAddAthleteHappyPath() {
        athletes.addAthlete(athlete1);
        assertEquals(athlete1, athletes.getAthletes().get(0));
    }

    @Test
    void testAddAthleteException() {
        try {
            Athlete athlete = null;
            athletes.addAthlete(athlete);
        } catch (NullPointerException e) {
            assertEquals("The athlete can t be added because is null", e.getMessage());
        }
    }

    @Test
    void testDisplayRankings(){
        Athlete athlete2 = new Athlete(10, "Emily", "US", "39:45", "xoxox", "xooxo", "xxxxx");
        Athlete athlete3 = new Athlete(12, "Luca", "IT", "41:23", "xxoxo", "xoxox", "oooxo");
        athletes.addAthlete(athlete1);
        athletes.addAthlete(athlete2);
        athletes.addAthlete(athlete3);
        athletes.displayRankings();
    }
}