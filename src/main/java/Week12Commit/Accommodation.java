package Week12Commit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Accommodation {
    @Setter
    private int id;
    private final String type;
    private final String bedType;
    private final int maxGuests;
    private final String description;
}