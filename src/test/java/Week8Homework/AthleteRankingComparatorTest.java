package Week8Homework;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AthleteRankingComparatorTest {
    Athlete athlete1 = new Athlete(11, "John", "SK", "40:10", "xooxo", "xxxox", "xxooo");
    Comparator<Athlete> comparator = new AthleteRankingComparator();

    @Test
    void testCompareHappyPath() {
        Athlete athlete2 = new Athlete(10, "Marcus", "UK", "30:11", "xoxxo", "xxxxx", "xxxxo");
        int compare = comparator.compare(athlete1, athlete2);
        assertEquals(1, compare);
    }

    @Test
    void testCompareException(){
        try{
            Athlete athlete3 = null;
            int compare = comparator.compare(athlete1, athlete3);
        } catch (NullPointerException e){
            assertEquals("One of the athletes doesn t have any info", e.getMessage());
        }
    }
}