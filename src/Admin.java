public class Admin extends Person {

    public Admin(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayRole() {
        System.out.println("Admin");
    }
}
