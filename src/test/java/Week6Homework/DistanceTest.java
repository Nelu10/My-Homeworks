package Week6Homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @ParameterizedTest
    @CsvSource ({
            "10, mm, 1.0",
            "10, dm, 100"
    })
    public void testConvertToCmParameterized(double value, String unitate, double expected){
        double result = Distance.convertToCm(value, unitate);
        assertEquals(expected, result, 0);
    }

    @Test
    public void testConvertToCm(){
        assertEquals(100, Distance.convertToCm(1,"m"), 0);
        assertEquals(150, Distance.convertToCm(15,"dm"), 0);
        assertEquals(2, Distance.convertToCm(20,"mm"), 0);
        assertEquals(100000, Distance.convertToCm(1,"km"), 0);
    }

}