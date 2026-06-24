/**
 * Represents an administrator in the system.
 * This class extends the {@link Person} class and provides a specific implementation
 * for the role display functionality.
 */
public class Admin extends Person {

    /**
     * Constructs a new Admin with the specified name and ID.
     * It initializes the admin using the constructor of the superclass.
     *
     * @param name the name of the administrator.
     * @param id the unique ID of the administrator.
     */
    public Admin(String name, String id) {
        super(name, id);
    }

    /**
     * Displays the role of the administrator.
     * Overrides the {@link Person#displayRole()} method to print "Admin".
     */
    @Override
    public void displayRole() {
        System.out.println("Admin");
    }
}