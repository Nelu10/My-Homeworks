package Week8Homework;

import java.io.BufferedWriter;
import java.io.IOException;

public class WriteResultsInCSVFile {

    public static void writeDataToCSVFile(AthletesRanking athletesRanking) {
        if (athletesRanking == null || athletesRanking.getAthletes().isEmpty()) {
            System.out.println("No athletes data available to write.");
            return;
        }
        String filePath = "C:\\Users\\gamme\\Desktop\\MyRepository\\untitled1\\src\\main\\resources\\athletes_output.csv";
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            writer.write("Number,Name,Country,SkiTime,FirstShooting,SecondShooting,ThirdShooting");
            writer.newLine();
            for (Athlete athlete : athletesRanking.getAthletes()) {
                writer.write(athlete.getAthleteNumber() + "," +
                        athlete.getAthleteName() + "," +
                        athlete.getAthleteCountryCode() + "," +
                        athlete.getSkiTimeResult() + "," +
                        arrayToString(athlete.getFirstShootingResults()) + "," +
                        arrayToString(athlete.getSecondShootingResults()) + "," +
                        arrayToString(athlete.getThirdShootingResults()));
                writer.newLine();
            }
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String arrayToString(ShootingResults[] results) {
        StringBuilder sb = new StringBuilder();
        for (ShootingResults result : results) {
            sb.append(result == ShootingResults.HIT ? "x" : "o");
        }
        return sb.toString();
    }
}