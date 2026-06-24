import java.sql.*;

public class HotelService {

    public void addRoom(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO rooms VALUES (?, true)"
            );
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
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

    public String showRooms() {
        String result = "";

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rooms");

            while (rs.next()) {
                result += "Room: " + rs.getInt("id") +
                        " Available: " + rs.getBoolean("available") + "\n";
            }

        } catch (Exception e) {
            result = e.toString();
        }

        return result;
    }
}
