package QuizzCode;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryGroupTest {

    @Test
    void testDeliver() {
        Package p = new Package("Loc", 5, 50, LocalDate.now());
        DeliveryGroup group = new DeliveryGroup(new GroupKey("Loc", LocalDate.now()), List.of(p));
        DeliveryResult result = group.deliver();
        assertEquals(50, result.getGroupValue());
        assertEquals(5.0, result.getRevenue());
    }
}