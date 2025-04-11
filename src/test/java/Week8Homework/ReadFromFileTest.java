package Week8Homework;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {

    @Test
    public void testReadDataFromCSVFile() {
        String csvFile = "Number,Name,Country,SkiTime,FirstShooting,SecondShooting,ThirdShooting\n" +
                "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        InputStream inputStream = new ByteArrayInputStream(csvFile.getBytes());
        ReadFromFile readFromFile = new ReadFromFile();
        AthletesRanking result = readFromFile.readDataFromCSVFile();
        assertNotNull(result, "The result should not be null");
        assertEquals(3, result.getAthletes().size(), "There should be 3 athletes in the ranking");
    }
    //dind t manage to succesful test the readDataFromCSVFileException test
}
