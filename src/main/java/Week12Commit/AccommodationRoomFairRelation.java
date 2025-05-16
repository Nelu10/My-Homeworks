package Week12Commit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccommodationRoomFairRelation {
    private int id;
    private int accommodationId;
    private int roomFairId;
}