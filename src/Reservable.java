/**
 * This interface defines the reservation behavior.
 * Any class that implements this interface
 * must provide a reserve method.
 */
public interface Reservable {

    /**
     * Reserves an object by changing its status.
     */
    void reserve();
}