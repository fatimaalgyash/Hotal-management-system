/**
 * This class represents the hotel in the system.
 * It stores the hotel name and displays hotel information.
 */
public class Hotel {

    private String name;

    /**
     * Constructor to create a hotel object.
     *
     * @param name the name of the hotel
     */
    public Hotel(String name) {
        this.name = name;
    }

    /**
     * Returns the hotel name.
     *
     * @return hotel name
     */
    public String getName() {
        return name;
    }

    /**
     * Displays the hotel name.
     */
    public void displayHotel() {
        System.out.println("Hotel: " + name);
    }
}