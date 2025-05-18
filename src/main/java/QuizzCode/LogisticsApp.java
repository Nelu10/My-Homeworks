package QuizzCode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogisticsApp {
    public static void main(String[] args) throws InterruptedException{
        startTheProgram();
    }
        public static void startTheProgram() throws InterruptedException{
        List<Package> packages = PackageLoader.loadPackages("src/main/resources/packages.txt");
        Map<GroupKey, List<Package>> groupedPackages = PackageGrouper.groupByLocationAndDate(packages);
        List<DeliveryGroup> deliveryGroups = groupedPackages.entrySet().stream()
                .map(entry -> DeliveryGroupFactory.createGroup(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        DeliveryExecutor deliveryExecutor = new DeliveryExecutor(deliveryGroups);
        List<DeliveryResult> results = deliveryExecutor.executeDeliveries();
        double totalValue = results.stream().mapToDouble(DeliveryResult::getGroupValue).sum();
        double totalRevenue = results.stream().mapToDouble(DeliveryResult::getRevenue).sum();
        System.out.println("Total package value " + totalValue);
        System.out.println("Total revenue " + totalRevenue);
    }
}