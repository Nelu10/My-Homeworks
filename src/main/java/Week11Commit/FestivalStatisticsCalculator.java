package Week11Commit;

import java.util.Map;
import java.util.stream.Collectors;

public class FestivalStatisticsCalculator {

    public Map<TicketType, Long> calculate(FestivalGate gate) {
        return gate.getTicketsQueue().stream()
                .collect(Collectors.groupingBy(ticketType -> ticketType, Collectors.counting()));
    }

    public int getTotalCount(Map<TicketType, Long> statistics) {
        return (int) statistics.values().stream()
                .mapToLong(Long::longValue).sum();
    }
}