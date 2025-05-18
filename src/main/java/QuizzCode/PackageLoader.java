package QuizzCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PackageLoader {
    public static List<Package> loadPackages(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .filter(line -> !line.trim().isEmpty())
                    .map(PackageLoader::parseLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static Package parseLine(String line) {
        String[] parts = line.split(",");
        return new Package(
                parts[0].trim(),
                Integer.parseInt(parts[1].trim()),
               Integer.parseInt(parts[2].trim()),
                LocalDate.parse(parts[3].trim())
        );
    }
}