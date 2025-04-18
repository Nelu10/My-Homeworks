package Week9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {
    private StudentRepository repository;
    private Student student;

    @BeforeEach
    public void setup() {
        repository = new StudentRepository();
        student = new Student("Ion", "Ionescu", LocalDate.of(2000, 5, 10), "M", "1");
    }

    @Test
    public void testAddStudentHappyPath() {
        repository.addStudent(student);
        assertTrue(repository.getAllStudents().contains(student));
    }

    @Test
    public void testAddStudentExceptionDuplicateId() {
        repository.addStudent(student);
        assertThrows(InvalidStudentException.class, () -> repository.addStudent(student));
    }

    @Test
    public void testDeleteStudentByIdHappyPath() {
        repository.addStudent(student);
        repository.deleteStudentById("1");
        assertFalse(repository.getAllStudents().contains(student));
    }

    @Test
    public void testDeleteStudentByIdExceptionEmptyId() {
        assertThrows(InvalidStudentException.class, () -> repository.deleteStudentById(""));
    }

    @Test
    public void testDeleteStudentByIdExceptionNotFound() {
        assertThrows(InvalidStudentException.class, () -> repository.deleteStudentById("9999"));
    }

    @Test
    public void testGetStudentsByAgeHappyPath() {
        repository.addStudent(student);
        int age = StudentUtils.calculateAge(student.getBirthDate());
        List<Student> result = repository.getStudentsByAge(String.valueOf(age));
        assertTrue(result.contains(student));
    }

    @Test
    public void testGetStudentsByAgeExceptionNonNumeric() {
        assertThrows(InvalidStudentException.class, () -> repository.getStudentsByAge("abc"));
    }

    @Test
    public void testGetStudentsByAgeExceptioNegative() {
        assertThrows(InvalidStudentException.class, () -> repository.getStudentsByAge("-5"));
    }

    @Test
    public void testListStudentsOrderedByLastNameHappyPath() {
        Student s2 = new Student("Maria", "Albescu", LocalDate.of(1998, 3, 5), "F", "2");
        repository.addStudent(student);
        repository.addStudent(s2);
        List<Student> list = repository.listStudentsOrderedBy("lastname");
        assertEquals("Albescu", list.get(0).getLastName());
    }

    @Test
    public void testListStudentsOrderedByHappyPathBirthDate() {
        Student s2 = new Student("Maria", "Albescu", LocalDate.of(1998, 3, 5), "F", "2");
        repository.addStudent(student);
        repository.addStudent(s2);
        List<Student> list = repository.listStudentsOrderedBy("birthdate");
        assertEquals("Albescu", list.get(0).getLastName());
    }

    @Test
    public void testListStudentsOrderedByExceptionEmptyInput() {
        assertThrows(InvalidStudentException.class, () -> repository.listStudentsOrderedBy(""));
    }

    @Test
    public void testListStudentsOrderedByExceptionInvalidCriteria() {
        assertThrows(InvalidStudentException.class, () -> repository.listStudentsOrderedBy("height"));
    }
}