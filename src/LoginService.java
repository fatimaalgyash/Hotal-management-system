import java.sql.*;

/**
 * This class handles user login.
 */
public class LoginService implements Loginable {

    /**
     * Checks username and password from database.
     *
     * @param username user name
     * @param password user password
     * @return true if login is successful, false otherwise
     */
    @Override
    public boolean login(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}