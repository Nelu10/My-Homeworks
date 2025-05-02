package Week10Homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersonParser {

    public List<Person> loadFromJson(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream input = new FileInputStream(fileName)) {
            return mapper.readValue(input, new TypeReference<List<Person>>() {});
        } catch (IOException e) {
            throw new FileNotFoundCustomException("File not found: " + fileName, e);
        }
    }
}