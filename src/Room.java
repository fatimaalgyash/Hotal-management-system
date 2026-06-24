/**
 * This class represents a room in the hotel.
 * It stores room information and manages room availability.
 */
public class Room implements Reservable {

    private  final int roomNumber;
    private boolean isAvailable;

    /**
     * Creates a new room.
     *
     * @param roomNumber the room number
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
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
     * Returns the availability status of the room.
     *
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Reserves the room by changing its availability status.
     */
    @Override
    public void reserve() {
        isAvailable = false;
    }

    /**
     * Makes the room available again.
     */
    public void freeRoom() {
        isAvailable = true;
    }
}