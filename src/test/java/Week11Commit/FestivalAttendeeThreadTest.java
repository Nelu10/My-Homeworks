package Week11Commit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalAttendeeThreadTest {

    @Test
    void testTicketAddedToQueue() throws InterruptedException{
        FestivalGate gate = new FestivalGate();
        FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(TicketGenerator.generateRandomTicket(), gate);
        Thread attendeeThread = new Thread(festivalAttendeeThread);
        attendeeThread.start();
        attendeeThread.join();
        assertEquals(1, gate.getTicketsQueue().size());
        assertEquals(festivalAttendeeThread.getTicketType(), gate.getTicketsQueue().peek());
    }
}