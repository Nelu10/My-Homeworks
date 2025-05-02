package Week10Homework;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonParserTest {

    PersonParser parser = new PersonParser();

    @Test
    void testLoadFromJsonHappyPath() throws IOException {
        List<Person> people = parser.loadFromJson("src/main/resources/people.json");
        assertNotNull(people);
        assertTrue(people.size() > 0);
        assertEquals("Ana", people.get(0).getFirstName());
    }

    @Test
    void testLoadFromJsonFileNotFound() {
        assertThrows(FileNotFoundCustomException.class, () -> parser.loadFromJson("invalidFile.json"));
    }
}