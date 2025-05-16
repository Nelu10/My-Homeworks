package Week12Commit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class RoomFair {
    @Setter
    private int id;
    private double value;
    private String season;
}