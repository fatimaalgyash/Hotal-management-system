/**
 * This class represents a guest in the hotel.
 * It inherits from the Person class.
 */
public class Guest extends Person {

    /**
     * Creates a guest object.
     *
     * @param name the guest name
     * @param id the guest ID
     */
    public Guest(String name, String id) {
        super(name, id);
    }

    /**
     * Displays the role of the person.
     */
    @Override
    public void displayRole() {
        System.out.println("Guest");
    }
}