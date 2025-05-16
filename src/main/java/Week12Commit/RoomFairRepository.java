package Week12Commit;

import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class RoomFairRepository {
    private final Connection conn;
    public int insert(RoomFair fair) throws SQLException {
        String sql = "INSERT INTO room_fair (value, season) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, fair.getValue());
        ps.setString(2, fair.getSeason());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            fair.setId(generatedId);
            return generatedId;
        }
        return -1;
    }
}