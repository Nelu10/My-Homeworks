package week9commit;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StudentRepository {
    private final Map<String, Student> students = new HashMap<>();
    private final StudentValidator validator = new StudentValidator();
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public void addStudent(Student student) {
        validator.validate(student);
        if (students.containsKey(student.getId())) {
            throw new InvalidStudentException("Student with this ID already exists");
        }
        students.put(student.getId(), student);
        logger.info("Student added: " + student.getId());
    }

    public void deleteStudentById(String id) {
        if (id == null || id.isBlank()) {
            throw new InvalidStudentException("ID is empty");
        }
        if (!students.containsKey(id)) {
            throw new InvalidStudentException("Student not found");
        }
        students.remove(id);
        logger.info("Student deleted: " + id);
    }

    public List<Student> getStudentsByAge(String ageStr) {
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            throw new InvalidStudentException("Age is not a number");
        }
        if (age < 0) {
            throw new InvalidStudentException("Age is negative");
        }
        return students.values().stream()
                .filter(s -> StudentUtils.calculateAge(s.getBirthDate()) == age)
                .collect(Collectors.toList());
    }

    public List<Student> listStudentsOrderedBy(String criteria) {
        if (criteria == null || criteria.isBlank()) {
            throw new InvalidStudentException("Order criteria is empty");
        }
        return students.values().stream()
                .sorted(getComparator(criteria))
                .collect(Collectors.toList());
    }

    private Comparator<Student> getComparator(String criteria) {
        return switch (criteria.toLowerCase(Locale.ROOT)) {
            case "lastname" -> Comparator.comparing(Student::getLastName);
            case "birthdate" -> Comparator.comparing(Student::getBirthDate);
            default -> throw new InvalidStudentException("Invalid sort criteria");
        };
    }

    public Collection<Student> getAllStudents() {
        return Collections.unmodifiableCollection(students.values());
    }
}