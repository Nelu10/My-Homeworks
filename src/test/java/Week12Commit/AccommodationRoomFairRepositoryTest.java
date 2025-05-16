package Week12Commit;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;

public class AccommodationRoomFairRepositoryTest {

    @Test
    public void testPrintAllRoomPrices() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/booking_db";
        String user = "postgres";
        String password = "Voievod2020";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            AccommodationRoomFairRepository repo = new AccommodationRoomFairRepository(conn);
            repo.printAllRoomPrices();
        }
    }
}