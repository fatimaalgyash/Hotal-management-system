public class Room implements Reservable {

    private int roomNumber;
    private boolean isAvailable;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void reserve() {
        isAvailable = false;
    }

    public void freeRoom() {
        isAvailable = true;
    }
}
