package Week9;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class StudentValidatorTest {
    private final StudentValidator validator = new StudentValidator();

    @Test
    public void testValidateHappyPath() {
        Student student = new Student("Ana", "Pop", LocalDate.of(2000, 1, 1), "F", "1");
        assertDoesNotThrow(() -> validator.validate(student));
    }

    @Test
    public void testValidateExceptionFirstNameEmpty() {
        Student student = new Student("", "Pop", LocalDate.of(2000, 1, 1), "F", "1");
        assertThrows(InvalidStudentException.class, () -> validator.validate(student));
    }

    @Test
    public void testValidateExceptionLastNameEmpty() {
        Student student = new Student("Ana", "", LocalDate.of(2000, 1, 1), "F", "1");
        assertThrows(InvalidStudentException.class, () -> validator.validate(student));
    }

    @Test
    public void testValidateExceptionBirthDateInvalid() {
        Student student = new Student("Ana", "Pop", LocalDate.of(2010, 1, 1), "F", "1");
        assertThrows(InvalidStudentException.class, () -> validator.validate(student));
    }

    @Test
    public void testValidateExceptionGendrInvalid() {
        Student student = new Student("Ana", "Pop", LocalDate.of(2000, 1, 1), "other", "1");
        assertThrows(InvalidStudentException.class, () -> validator.validate(student));
    }

    @Test
    public void testValidateExceptionIdEmpty() {
        Student student = new Student("Ana", "Pop", LocalDate.of(2000, 1, 1), "F", "");
        assertThrows(InvalidStudentException.class, () -> validator.validate(student));
    }
}