package week9commit;

import java.time.LocalDate;
import java.util.Locale;

public class StudentValidator {

    public void validate(Student student) {
        if (student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new InvalidStudentException("First name is empty");
        }

        if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new InvalidStudentException("Last name is empty");
        }

        LocalDate birthDate = student.getBirthDate();
        int currentYear = LocalDate.now().getYear();
        if (birthDate.getYear() < 1900 || birthDate.getYear() > currentYear - 18) {
            throw new InvalidStudentException("Birth date out of valid range");
        }

        String gender = student.getGender().toLowerCase(Locale.ROOT);
        if (!(gender.equals("male") || gender.equals("female") || gender.equals("m") || gender.equals("f"))) {
            throw new InvalidStudentException("Invalid gender");
        }

        if (student.getId() == null || student.getId().isBlank()) {
            throw new InvalidStudentException("ID is empty");
        }
    }
}
