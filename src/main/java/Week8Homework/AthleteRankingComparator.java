package Week8Homework;

import java.util.Comparator;

public class AthleteRankingComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete athlete1, Athlete athlete2){
        if(athlete1 == null || athlete2 == null){
            throw new NullPointerException("One of the athletes doesn t have any info");
        }
    int athlete1Result = athlete1.getCalculateSkiTimeResult(athlete1.getSkiTimeResult());
    int athlete2Result = athlete2.getCalculateSkiTimeResult(athlete2.getSkiTimeResult());
    return Integer.compare(athlete1Result, athlete2Result);
    }
}