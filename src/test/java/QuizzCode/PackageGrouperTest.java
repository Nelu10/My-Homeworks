package QuizzCode;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PackageGrouperTest {

    @Test
    void testGroupByLocationAndDate() {
        Package p1 = new Package("LocA", 10, 100, LocalDate.of(2023,1,1));
        Package p2 = new Package("LocA", 5, 50, LocalDate.of(2023,1,1));
        Package p3 = new Package("LocB", 7, 70, LocalDate.of(2023,1,2));
        List<Package> packages = List.of(p1, p2, p3);
        Map<GroupKey, List<Package>> grouped = PackageGrouper.groupByLocationAndDate(packages);
        assertEquals(2, grouped.size());
        GroupKey keyA = new GroupKey("LocA", LocalDate.of(2023,1,1));
        assertTrue(grouped.containsKey(keyA));
        assertEquals(2, grouped.get(keyA).size());
        GroupKey keyB = new GroupKey("LocB", LocalDate.of(2023,1,2));
        assertTrue(grouped.containsKey(keyB));
        assertEquals(1, grouped.get(keyB).size());
    }
}