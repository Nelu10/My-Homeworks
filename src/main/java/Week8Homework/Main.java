package Week8Homework;

public class Main {
    public static void main(String[] args) {
        startTheProgram();
    }

    public static AthletesRanking startTheProgram() {
        AthletesRanking athletesRanking = readFromFile();
        if (athletesRanking != null && !athletesRanking.getAthletes().isEmpty()) {
            System.out.println("Athletes data available to write.");
            writeInCSVFile(athletesRanking);
            return athletesRanking;
        } else {
            System.out.println("File is empty");
            return null;
        }
    }

    public static AthletesRanking readFromFile(){
        ReadFromFile readFromFile = new ReadFromFile();
        return readFromFile.readDataFromCSVFile();
    }

    public static void writeInCSVFile(AthletesRanking athletesRanking){
        WriteResultsInCSVFile writeResultsInCSVFile = new WriteResultsInCSVFile();
        writeResultsInCSVFile.writeDataToCSVFile(athletesRanking);
    }
}
