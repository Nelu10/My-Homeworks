package week9commit;

import java.time.LocalDate;
import java.time.Period;

public class StudentUtils {
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
        //Period.beetween is something new that i found out while watching tiktoks
    }
}
