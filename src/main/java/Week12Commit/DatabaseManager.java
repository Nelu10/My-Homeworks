package Week12Commit;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/booking_db";
        String user = "postgres";
        String password = "Voievod2020";
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            AccommodationRepository accRepo = new AccommodationRepository(conn);
            RoomFairRepository fairRepo = new RoomFairRepository(conn);
            AccommodationRoomFairRepository relRepo = new AccommodationRoomFairRepository(conn);
            Accommodation acc = new Accommodation(0, "Apartment", "King", 2, "Near the beach");
            int accId = accRepo.insert(acc);
            RoomFair fair = new RoomFair(0, 120.0, "Summer");
            int fairId = fairRepo.insert(fair);
            relRepo.insert(accId, fairId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}