package Week11Commit;

import java.util.Map;

public class FestivalStatisticsPrinter {
    public void printStatisticsResults(Map<TicketType, Long> statistics) {
        statistics.forEach((ticketType, count) ->
                System.out.println(ticketType + ": " + count + " oameni"));
        int total = (int) statistics.values().stream()
                .mapToLong(Long::longValue).sum();
        System.out.println("In total " + total + " oameni");
    }
}