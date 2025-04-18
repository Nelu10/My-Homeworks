package Week8Homework;

import java.io.*;

public class ReadFromFile {

    public AthletesRanking readDataFromCSVFile() {
        AthletesRanking athletesRanking = new AthletesRanking();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("athletes.csv");
        if (inputStream == null) {
            System.out.println("File not found");
            return athletesRanking;
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;

                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    String[] records = line.split(",");
                    if (records.length == 7) {
                        int number = Integer.parseInt(records[0]);
                        String name = records[1];
                        String country = records[2];
                        String skiTimeResult = records[3];
                        String firstShooting = records[4];
                        String secondShooting = records[5];
                        String thirdShooting = records[6];
                        Athlete athlete = new Athlete(number, name, country, skiTimeResult, firstShooting, secondShooting, thirdShooting);
                        athletesRanking.addAthlete(athlete);
                    } else {
                        System.out.println("Invalid data format in line: " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            athletesRanking.displayRankings();
        }
        return athletesRanking;
    }
}
