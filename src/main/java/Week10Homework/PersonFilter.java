package Week10Homework;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonFilter {

    public static int extractMonth(String dateOfBirth){
        String[] dateParts = dateOfBirth.split("-");
        return Integer.parseInt(dateParts[1]);
    }

    public static List<Person> sortByMonth(List<Person> people, int targetMonth){
        return people.stream()
                .filter(p -> extractMonth(p.getDateOfBirth()) == targetMonth)
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .collect(Collectors.toList());
    }
}