package Week11Commit;

public class FestivalAttendeeThread implements Runnable{
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = TicketGenerator.generateRandomTicket();
        this.gate = festivalGate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        gate.addTicket(ticketType);
    }
}