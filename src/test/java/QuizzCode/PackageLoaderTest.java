package QuizzCode;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PackageLoaderTest {

    @Test
    void testLoadPackages() throws Exception{
        Path tempFile = Files.createTempFile("packages", ".txt");
        Files.writeString(tempFile,
                "Floresti,7,100,2017-09-02\n" +
                        "Turda,29,200,2017-09-01\n");
        List<Package> packages = PackageLoader.loadPackages(tempFile.toString());
        assertEquals(2, packages.size());
        Package p = packages.get(0);
        assertEquals("Floresti", p.getLocation());
        assertEquals(7, p.getDistance());
        assertEquals(100, p.getValue());
        assertEquals(LocalDate.of(2017, 9, 2), p.getDeliveryDate());
        Files.deleteIfExists(tempFile);
    }
}