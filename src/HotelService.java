import java.sql.*;

public class HotelService {

    public void addRoom(int id) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO rooms VALUES (?, NULL, NULL, true)"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String updateRoom(int roomId, String type, double price) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE rooms SET type=?, price=? WHERE id=?"
            );

            ps.setString(1, type);
            ps.setDouble(2, price);
            ps.setInt(3, roomId);

            int rows = ps.executeUpdate();

            return rows > 0 ? "Room Updated!" : "Room Not Found!";

        } catch (Exception e) {
            return e.toString();
        }
    }

    public String deleteRoom(int roomId) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM rooms WHERE id=?"
            );

            ps.setInt(1, roomId);

            int rows = ps.executeUpdate();

            return rows > 0 ? "Room Deleted!" : "Room Not Found!";

        } catch (Exception e) {
            return e.toString();
        }
    }

    public String showRooms() {

        String result = "";

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM rooms");

            while (rs.next()) {

                result += "Room: " + rs.getInt("id")
                        + " | Type: " + rs.getString("type")
                        + " | Price: " + rs.getDouble("price")
                        + " | Available: " + rs.getBoolean("available")
                        + "\n";
            }

        } catch (Exception e) {
            return e.toString();
        }

        return result;
    }

    public String bookRoom(int roomId, String guestName) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                    "INSERT INTO guests(name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps1.setString(1, guestName);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();
            int guestId = rs.getInt(1);

            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO bookings(guest_id, room_id) VALUES (?, ?)"
            );

            ps2.setInt(1, guestId);
            ps2.setInt(2, roomId);
            ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(
                    "UPDATE rooms SET available=false WHERE id=?"
            );

            ps3.setInt(1, roomId);
            ps3.executeUpdate();

            return "Booked!";

        } catch (Exception e) {
            return e.toString();
        }
    }

    public String checkOut(int roomId) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE rooms SET available=true WHERE id=?"
            );

            ps.setInt(1, roomId);
            ps.executeUpdate();

            return "Checked out!";

        } catch (Exception e) {
            return e.toString();
        }
    }
}