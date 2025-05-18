package QuizzCode;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryExecutorTest {

    @Test
    void testExecuteDeliveries() throws InterruptedException {
        Package p1 = new Package("Loc1", 10, 100, LocalDate.now());
        Package p2 = new Package("Loc2", 20, 200, LocalDate.now());
        DeliveryGroup g1 = new DeliveryGroup(new GroupKey("Loc1", LocalDate.now()), List.of(p1));
        DeliveryGroup g2 = new DeliveryGroup(new GroupKey("Loc2", LocalDate.now()), List.of(p2));
        DeliveryExecutor executor = new DeliveryExecutor(List.of(g1, g2));
        List<DeliveryResult> results = executor.executeDeliveries();
        assertEquals(2, results.size());
        assertTrue(results.stream().anyMatch(r -> r.getGroupValue() == 100 && r.getRevenue() == 10));
        assertTrue(results.stream().anyMatch(r -> r.getGroupValue() == 200 && r.getRevenue() == 20));
    }
}