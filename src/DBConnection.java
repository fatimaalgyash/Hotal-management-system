import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is responsible for establishing a connection
 * to the hotel database.
 */
public class DBConnection {

    /**
     * Creates and returns a connection to the database.
     *
     * @return Connection object if the connection is successful,
     *         otherwise returns null.
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel",
                    "root",
                    "20154091"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}