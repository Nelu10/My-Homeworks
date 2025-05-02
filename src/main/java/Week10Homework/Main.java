package Week10Homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        processTheFile();
    }

    public static void processTheFile() {
        String inputFileName = "src/main/resources/people.json";
        int targetMonth = 3;
        String outputFileName = "sortedPeople.json";
        try {
            PersonParser parser = new PersonParser();
            List<Person> people = parser.loadFromJson(inputFileName);
            List<Person> filteredPeople = PersonFilter.sortByMonth(people, targetMonth);
            PersonWriter writer = new PersonWriter();
            writer.writeToJson(filteredPeople, outputFileName);
            System.out.println("Succes");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}