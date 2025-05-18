package QuizzCode;

import java.util.List;

public class DeliveryGroupFactory {
    public static DeliveryGroup createGroup(GroupKey key, List<Package> packages) {
        return new DeliveryGroup(key, packages);
    }
}