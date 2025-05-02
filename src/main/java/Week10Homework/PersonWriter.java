package Week10Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PersonWriter {

    public void writeToJson(List<Person> people, String fileName) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        List<PersonNameOnly> nameOnlyList = people.stream()
                .map(p -> new PersonNameOnly(p.getFirstName(), p.getLastName()))
                .collect(Collectors.toList());
        File outputFile = new File(fileName);
        mapper.writeValue(outputFile, nameOnlyList);
    }
}