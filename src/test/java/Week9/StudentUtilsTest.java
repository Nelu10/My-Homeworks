package Week9;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class StudentUtilsTest {
    @Test
    public void testCalculateAgeHappyPath() {
        LocalDate birthDate = LocalDate.now().minusYears(20);
        int age = StudentUtils.calculateAge(birthDate);
        assertEquals(20, age);
    }
}