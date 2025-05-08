package Week11Commit;

import java.util.Random;

public class TicketGenerator {
    protected static TicketType generateRandomTicket(){
        TicketType[] values = TicketType.values();
        return values[new Random().nextInt(values.length)];
    }
}