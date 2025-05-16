package Week12Commit;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class AccommodationRoomFairRepository {
    private final Connection conn;

    public void insert(int accommodationId, int roomFairId) throws SQLException {
        String sql = "INSERT INTO accommodation_room_fair_relation (accommodation_id, room_fair_id) VALUES(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, accommodationId);
        ps.setInt(2, roomFairId);
        ps.executeUpdate();
    }

    public void printAllRoomPrices() throws SQLException {
        String sql = """
                SELECT a.type, a.bed_type, a.max_guests, a.description, rf.value, rf.season
                FROM accommodation a
                JOIN accommodation_room_fair_relation rel ON a.id = rel.accommodation_id
                JOIN room_fair rf ON rf.id = rel.room_fair_id
        """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.printf(
                    "Type: %s  Bed: %s  Max Guests: %d  Desc: %s  Price: %.2f  Season: %s\n",
                    rs.getString("type"),
                    rs.getString("bed_type"),
                    rs.getInt("max_guests"),
                    rs.getString("description"),
                    rs.getDouble("value"),
                    rs.getString("season")
            );
        }
    }
}