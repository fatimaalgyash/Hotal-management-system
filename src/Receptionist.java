public class Receptionist extends Person {

    public Receptionist(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayRole() {
        System.out.println("Receptionist");
    }
}
