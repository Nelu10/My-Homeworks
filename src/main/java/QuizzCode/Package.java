package QuizzCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Package {
    private final String location;
    private final int distance;
    private final int value;
    private final LocalDate deliveryDate;
}