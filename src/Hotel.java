public class Hotel {

    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayHotel() {
        System.out.println("Hotel: " + name);
    }
}
