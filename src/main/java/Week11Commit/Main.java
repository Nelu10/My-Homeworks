package Week11Commit;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        Thread statsThread = new Thread(new FestivalStatisticsThread(
                gate, new FestivalStatisticsCalculator(), new FestivalStatisticsPrinter()
        ));
        statsThread.start();
        threadGenerator(gate);
    }

    public static void threadGenerator(FestivalGate gate) {
        Thread generatorThread = new Thread(() -> {
            while (true){
                generateAndStart100Attendee(gate);
                try {
                    Thread.sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        generatorThread.start();
    }

    public static void generateAndStart100Attendee(FestivalGate gate) {
        IntStream.range(0, 100)
                .mapToObj(i -> new FestivalAttendeeThread(TicketGenerator.generateRandomTicket(), gate))
                .map(Thread::new)
                .forEach(Thread::start);
    }
}