package QuizzCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class GroupKey {
    private final String location;
    private final LocalDate date;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        GroupKey groupKey = (GroupKey) o;
        return Objects.equals(location, groupKey.location) && Objects.equals(date, groupKey.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, date);
    }
}