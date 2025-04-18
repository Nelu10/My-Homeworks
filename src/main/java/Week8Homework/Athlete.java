package Week8Homework;

public class Athlete extends AthleteRankingComparator{
    private final int athleteNumber;
    private final String athleteName;
    private final String athleteCountryCode;
    private final String skiTimeResult;
    private final ShootingResults[] firstShootingResults;
    private final ShootingResults[] secondShootingResults;
    private final ShootingResults[] thirdShootingResults;

    public Athlete(int number, String name, String countryCode, String skiTimeResult, String firstShootingResults, String secondShootingResults, String thirdShootingResults) {
        this.athleteNumber = number;
        this.athleteName = name;
        this.athleteCountryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingResults = parseShootingResults(firstShootingResults);
        this.secondShootingResults = parseShootingResults(secondShootingResults);
        this.thirdShootingResults = parseShootingResults((thirdShootingResults));
    }

    public ShootingResults[] parseShootingResults(String results){
        ShootingResults[] shootingResults = new ShootingResults[results.length()];
        for(int r=0; r<results.length(); r++) {
            char result = results.charAt(r);
            if (result == 'x') {
                shootingResults[r] = ShootingResults.HIT;
            } else if (result == 'o') {
                shootingResults[r] = ShootingResults.MISS;
            } else {
                throw new IllegalArgumentException("Invalid character " + result);
            }
        }
            return shootingResults;
    }

    public int countMisses(ShootingResults[] results){
        int misses = 0;
        for(ShootingResults m : results){
            if(m == ShootingResults.MISS){
                misses++;
            }
        }
        return misses;
    }

    public int getPenaltyTime(ShootingResults[] firstShootingResults, ShootingResults[] secondShootingResults, ShootingResults[] thirdShootingResults){
        int penaltyTime = 0;
        if(firstShootingResults == null || secondShootingResults == null || thirdShootingResults == null){
            throw new NullPointerException("No misses to count");
        }
        penaltyTime += countMisses(firstShootingResults) * 10;
        penaltyTime += countMisses(secondShootingResults) * 10;
        penaltyTime += countMisses(thirdShootingResults) * 10;
        return penaltyTime;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public int getCalculateSkiTimeResult(String skiTimeResult){
        if(skiTimeResult == null){
            throw new NullPointerException("The athlete doesn t have a skitime result yet");
        }
        String[] time = skiTimeResult.split(":");
        int minutes = Integer.parseInt(time[0]);
        int seconds = Integer.parseInt(time[1]);
        int penaltySeconds = getPenaltyTime(firstShootingResults, secondShootingResults, thirdShootingResults);
        int finalTime = minutes * 60 + seconds + penaltySeconds;
        return finalTime;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getAthleteCountryCode() {
        return athleteCountryCode;
    }

    public ShootingResults[] getFirstShootingResults() {
        return firstShootingResults;
    }

    public ShootingResults[] getSecondShootingResults() {
        return secondShootingResults;
    }

    public ShootingResults[] getThirdShootingResults() {
        return thirdShootingResults;
    }

    @Override
    public String toString() {
        int penaltyTime = getPenaltyTime(firstShootingResults, secondShootingResults, thirdShootingResults);
        return athleteName + " " + skiTimeResult + " (" + skiTimeResult + " + " + penaltyTime + ")";
    }

}