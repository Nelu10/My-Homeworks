package Week10Homework;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonFilterTest {

    @Test
    void testSortByMonth(){
        List<Person> people = Arrays.asList(
                new Person("Ion", "Dumitrescu", "1990-03-15"),
                new Person("Dan", "Popescu", "1991-03-20"),
                new Person("Stefan", "Ciobanu", "1992-04-05")
        );
        List<Person> sortedPeople = PersonFilter.sortByMonth(people, 3);
        assertEquals(2, sortedPeople.size());
        assertEquals("Dan", sortedPeople.get(0).toString());
        assertEquals("Ion", sortedPeople.get(1).toString());
    }
}