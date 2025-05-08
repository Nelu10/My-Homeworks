package Week11Commit;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class TicketGeneratorTest {

    @Test
    void testGenerateRandomTicket() {
        TicketType ticket = TicketGenerator.generateRandomTicket();
        assertNotNull(ticket);
        assertTrue(EnumSet.allOf(TicketType.class).contains(ticket));
    }
}