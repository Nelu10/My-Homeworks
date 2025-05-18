package QuizzCode;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DeliveryExecutor {
    private final List<DeliveryGroup> deliveryGroups;

    public List<DeliveryResult> executeDeliveries() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(deliveryGroups.size());
        List<Future<DeliveryResult>> futures = deliveryGroups.stream()
                .map(group -> executor.submit(group::deliver))
                .collect(Collectors.toList());
        List<DeliveryResult> results = new ArrayList<>();
        for (Future<DeliveryResult> future : futures) {
            try {
                results.add(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return results;
    }
}