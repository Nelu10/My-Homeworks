package Week11Commit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FestivalStatisticsCalculatorTest {
    FestivalStatisticsCalculator calculator = new FestivalStatisticsCalculator();

    @BeforeEach
    void setCalculator() {
        calculator = new FestivalStatisticsCalculator();
    }
    @Test
    void testCalculate() {
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FULL);
        Map<TicketType, Long> statistics = calculator.calculate(gate);
        assertEquals(1, statistics.size());
        assertEquals(3L, statistics.get(TicketType.FULL));
    }

    @Test
    void testGetTotalCount() {
        Map<TicketType, Long> stats = Map.of(
                TicketType.FULL, 3L,
                TicketType.FREE_PAS, 2L
        );
        int total = calculator.getTotalCount(stats);
        assertEquals(5, total);
    }
}