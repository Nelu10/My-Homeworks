package QuizzCode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PackageGrouper {
    public static Map<GroupKey, List<Package>> groupByLocationAndDate(List<Package> packages) {
        return packages.stream()
                .collect(Collectors.groupingBy(pkg -> new GroupKey(pkg.getLocation(), pkg.getDeliveryDate())));
    }
}