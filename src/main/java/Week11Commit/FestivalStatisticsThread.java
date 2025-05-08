package Week11Commit;

import java.util.Map;

public class FestivalStatisticsThread implements Runnable{
    private final FestivalGate gate;
    private final FestivalStatisticsCalculator calculator;
    private final FestivalStatisticsPrinter printer;

    public FestivalStatisticsThread(FestivalGate gate, FestivalStatisticsCalculator calculator, FestivalStatisticsPrinter printer) {
        this.gate = gate;
        this.calculator = calculator;
        this.printer = printer;
    }

    @Override
    public void run() {
        if(gate == null) {
            throw new NullPointerException();
        }
        while(true){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(gate.getTicketsQueue().isEmpty()){
                continue;
            }

            Map<TicketType, Long> statistics = calculator.calculate(gate);
            printer.printStatisticsResults(statistics);
        }
    }
    //Am tot incercat sa testez in diferite moduri metoda asta si am realizat ca din cauza ca e intr un loop infinit,
    //pot s-o testez doar daca o schimb momentan pentru un test rapid dar apoi s-o scriu inapoi cum e acum
}