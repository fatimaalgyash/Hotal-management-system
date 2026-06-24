/**
 * This class represents a receptionist in the hotel system.
 * It inherits from the Person class.
 */
public class Receptionist extends Person {

    /**
     * Creates a receptionist object.
     *
     * @param name the receptionist's name
     * @param id the receptionist's ID
     */
    public Receptionist(String name, String id) {
        super(name, id);
    }

    /**
     * Displays the role of the user.
     */
    @Override
    public void displayRole() {
        System.out.println("Receptionist");
    }
}