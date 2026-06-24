/**
 * This class represents a booking in the hotel system.
 * It links a guest with a room and handles the booking process.
 */
public class Booking {

    private final Guest guest;
    private  final Room room;

    /**
     * Constructor to create a booking with a guest and a room
     * @param guest the guest who is booking
     * @param room the room to be booked
     */
    public Booking(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
    }

    /**
     * Returns the guest of this booking
     * @return Guest object
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * Returns the room of this booking
     * @return Room object
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Confirms the booking by reserving the room
     */
    public void confirmBooking() {
        room.reserve();
    }
}
