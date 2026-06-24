/**
 * Represents an abstract base class for a person in the system.
 * This class serves as a template for other classes that inherit from it.
 */
public abstract class Person {

    private final String name;
    private final String id;

    /**
     * Constructs a new Person with the specified name and ID.
     *
     * @param name the name of the person.
     * @param id the unique ID of the person.
     */
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return a String representing the person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the ID of the person.
     *
     * @return a String representing the person's unique ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Abstract method to display the specific role of the person.
     * Subclasses must provide an implementation for this method.
     */
    public abstract void displayRole();
}

