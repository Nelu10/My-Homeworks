package Week12Commit;

import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class AccommodationRepository {
    private final Connection conn;

    public int insert(Accommodation acc) throws SQLException {
        String sql = "INSERT INTO accommodation (type, bed_type, max_guests, description) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, acc.getType());
        ps.setString(2, acc.getBedType());
        ps.setInt(3, acc.getMaxGuests());
        ps.setString(4, acc.getDescription());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            acc.setId(generatedId);
            return generatedId;
        }
        return -1;
    }
}