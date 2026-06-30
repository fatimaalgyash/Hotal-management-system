/**
 * This class represents a room in the hotel.
 * It stores room information and manages room availability.
 */
public class Room implements Reservable {

    private final int roomNumber;
    private String type;
    private double price;
    private boolean available;

    /**
     * Creates a new room.
     *
     * @param roomNumber room number
     * @param type room type
     * @param price room price
     */
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true;
    }

    /**
     * Returns the room number.
     *
     * @return room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the room type.
     *
     * @return room type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the room type.
     *
     * @param type new room type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the room price.
     *
     * @return room price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the room price.
     *
     * @param price new room price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Checks whether the room is available.
     *
     * @return true if available, otherwise false
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Reserves the room.
     */
    @Override
    public void reserve() {
        available = false;
    }

    /**
     * Frees the room.
     */
    public void freeRoom() {
        available = true;
    }
}