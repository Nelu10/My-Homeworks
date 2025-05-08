package Week11Commit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalGateTest {

    @Test
    void testAddTicket() {
        FestivalGate gate = new FestivalGate();
        TicketType ticket = TicketType.FULL;
        gate.addTicket(ticket);
        assertEquals(1, gate.getTicketsQueue().size());
        assertTrue(gate.getTicketsQueue().contains(ticket));
    }
}