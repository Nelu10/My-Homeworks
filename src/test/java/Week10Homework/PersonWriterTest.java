package Week10Homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonWriterTest {

    @Test
    void testWriteToJson() throws IOException {
        List<Person> people = Arrays.asList(
                new Person("Ion", "Nicolau", "1990-03-15"),
                new Person("Dan", "Petrescu", "1991-03-20")
        );
        PersonWriter writer = new PersonWriter();
        writer.writeToJson(people, "src/main/resources/testOutput.json");

        File outputFile = new File("src/main/resources/testOutput.json");
        assertTrue(outputFile.exists());

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> nameOnlyList = Arrays.asList(mapper.readValue(outputFile, Map[].class));
        assertEquals(2, nameOnlyList.size());
        assertEquals("Ion", nameOnlyList.get(0).get("firstName"));
        assertEquals("Dan", nameOnlyList.get(1).get("firstName"));
    }
}