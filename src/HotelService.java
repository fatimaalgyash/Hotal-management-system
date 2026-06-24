import java.sql.*;

/**
 * This class handles hotel operations such as adding rooms,
 * booking rooms, checking out guests, displaying rooms,
 * and deleting rooms from the database.
 */
public class HotelService {

    /**
     * Adds a new room to the database.
     *
     * @param id the room number
     */
    public void addRoom(int id) {
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO rooms VALUES (?, true)"
                );
                ps.setInt(1, id);
                ps.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Books a room for a guest.
     *
     * @param roomId the room number
     * @param guestName the guest name
     * @return booking status message
     */
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

    /**
     * Checks out a guest and makes the room available again.
     *
     * @param roomId the room number
     * @return checkout status message
     */
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

    /**
     * Displays all rooms and their availability status.
     *
     * @return a string containing room information
     */
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

    /**
     * Deletes a room from the database.
     *
     * @param roomId the room number
     * @return deletion status message
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
                return "Room not found!";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error!";
        }
    }
}