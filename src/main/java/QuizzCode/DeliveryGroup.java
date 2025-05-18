package QuizzCode;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class DeliveryGroup {
    private final GroupKey key;
    private final List<Package> packages;

    public DeliveryResult deliver() {
        int groupValue = calculateGroupValue();
        int distance = packages.get(0).getDistance();
        double revenue = calculateRevenue(distance);
        System.out.println("Delivering for " + key.getLocation() + " and date " + key.getDate() + " in " + distance + " seconds");
        try {
            TimeUnit.SECONDS.sleep(distance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new DeliveryResult(groupValue, revenue);
    }

    private int calculateGroupValue() {
        return packages.stream().mapToInt(Package::getValue).sum();
    }

    private double calculateRevenue(int distance) {
        return distance * 1.0;
    }
}