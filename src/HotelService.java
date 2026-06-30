import java.sql.*;

/**
 * This class provides hotel services such as adding, updating,
 * deleting, booking, checking out, and displaying rooms.
 */
public class HotelService {

    /**
     * Adds a new room.
     *
     * @param id room ID
     * @param type room type
     * @param price room price
     */
    public void addRoom(int id, String type, double price) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO rooms(id,type,price,available) VALUES(?,?,?,true)"
            );

            ps.setInt(1, id);
            ps.setString(2, type);
            ps.setDouble(3, price);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates room information.
     *
     * @param roomId room ID
     * @param type new room type
     * @param price new room price
     * @return result message
     */
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

            if (rows > 0) {
                return "Room Updated!";
            } else {
                return "Room Not Found!";
            }

        } catch (Exception e) {
            return e.toString();
        }
    }

    /**
     * Books a room.
     *
     * @param roomId room ID
     * @param guestName guest name
     * @return result message
     */
    public String bookRoom(int roomId, String guestName) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                    "INSERT INTO guests(name) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps1.setString(1, guestName);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            rs.next();

            int guestId = rs.getInt(1);

            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO bookings(guest_id,room_id) VALUES(?,?)"
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

    /**
     * Checks out a room.
     *
     * @param roomId room ID
     * @return result message
     */
    public String checkOut(int roomId) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE rooms SET available=true WHERE id=?"
            );

            ps.setInt(1, roomId);

            ps.executeUpdate();

            return "Checked Out!";

        } catch (Exception e) {

            return e.toString();

        }
    }

    /**
     * Displays all rooms.
     *
     * @return room list
     */
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
                        + " | Available: "
                        + rs.getBoolean("available") + "\n";}

        } catch (Exception e) {

            result = e.toString();

        }

        return result;
    }

    /**
     * Deletes a room.
     *
     * @param roomId room ID
     * @return result message
     */
    public String deleteRoom(int roomId) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM rooms WHERE id=?"
            );

            ps.setInt(1, roomId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                return "Room Deleted!";
            } else {
                return "Room Not Found!";
            }

        } catch (Exception e) {

            return "Error: " + e.getMessage();

        }
    }
}