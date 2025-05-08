package Week11Commit;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final Queue<TicketType> ticketsQueue = new ConcurrentLinkedQueue<>();

    public void addTicket(TicketType ticket) {
        ticketsQueue.add(ticket);
    }

    public Queue<TicketType> getTicketsQueue() {
        return ticketsQueue;
    }
}