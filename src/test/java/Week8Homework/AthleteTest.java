package Week8Homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {
    Athlete athlete = new Athlete(11, "John", "SK", "40:10", "xooxo", "xxxox", "xxooo");
    ShootingResults[] results = {ShootingResults.HIT, ShootingResults.HIT, ShootingResults.MISS, ShootingResults.MISS, ShootingResults.MISS};

    @Test
    void testParseShootingResultsHappyPath() {
        String results = "xooxo";
        ShootingResults[] parsedResults = athlete.parseShootingResults(results);
        assertEquals(ShootingResults.HIT, parsedResults[0]);
        assertEquals(ShootingResults.MISS, parsedResults[1]);
        assertEquals(ShootingResults.MISS, parsedResults[2]);
        assertEquals(ShootingResults.HIT, parsedResults[3]);
        assertEquals(ShootingResults.MISS, parsedResults[4]);
    }

    @Test
    void testParseShootingResultsException() {
        String invalidResults = "xoox0";
        try {
            athlete.parseShootingResults(invalidResults);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid character 0", e.getMessage());
        }
    }

    @Test
    void testCountMisses() {
        int misses = 0;
        assertEquals(3, athlete.countMisses(results));
    }

    @Test
    void testGetPenaltyTimeHappyPath() {
        int penaltyTime = athlete.countMisses(results) * 10;
        assertEquals(30, penaltyTime);
    }

    @Test
    void testGetPenaltyTimeException() {
        try {
            int penaltyTime = athlete.getPenaltyTime(results, results, null) * 10;
        } catch (NullPointerException e) {
            assertEquals("No misses to count", e.getMessage());
        }
    }

    @Test
    void testGetCalculatedSkiTimeResultHappyPath() {
        String time = "30:11";
        int finalTIme = athlete.getCalculateSkiTimeResult(time);
        assertEquals(1881, finalTIme);
    }

    @Test
    void testGetCalculatedSkiTimeResultException() {
            try {
                String time = null;
                int finalTime = athlete.getCalculateSkiTimeResult(time);
            } catch (NullPointerException e) {
                assertEquals("The athlete doesn t have a skitime result yet", e.getMessage());
            }
        }
        //this was the most difficult one because in Athlete this method had the exception thrown
        //after splitting the skiTimeResult so it took me a while to understand why it's not working
}