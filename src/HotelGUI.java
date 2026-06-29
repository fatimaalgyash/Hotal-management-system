import javax.swing.*;

/**
 * This class creates the graphical user interface (GUI)
 * for the Hotel Management System.
 */
public class HotelGUI {

    /**
     * Creates the GUI according to the user role.
     *
     * @param role user role (Admin or Receptionist)
     */
    public HotelGUI(String role) {

        HotelService service = new HotelService();

        JFrame frame = new JFrame("Hotel System");
        frame.setSize(400, 400);
        frame.setLayout(null);

        JTextField roomField = new JTextField();
        roomField.setBounds(120, 20, 150, 25);
        frame.add(roomField);

        JTextField guestField = new JTextField();
        guestField.setBounds(120, 60, 150, 25);
        frame.add(guestField);

        JTextArea area = new JTextArea();
        area.setBounds(20, 180, 350, 150);
        frame.add(area);

        JButton add = new JButton("Add Room");
        add.setBounds(20, 100, 120, 30);
        frame.add(add);

        JButton book = new JButton("Book");
        book.setBounds(150, 100, 120, 30);
        frame.add(book);

        JButton out = new JButton("CheckOut");
        out.setBounds(20, 140, 120, 30);
        frame.add(out);

        JButton show = new JButton("Show");
        show.setBounds(150, 140, 120, 30);
        frame.add(show);

        JButton delete = new JButton("Delete");
        delete.setBounds(280, 100, 90, 30);
        frame.add(delete);

        // صلاحيات المستخدم
        if (role.equalsIgnoreCase("Admin")) {

            book.setVisible(false);
            out.setVisible(false);
            guestField.setVisible(false);

        } else if (role.equalsIgnoreCase("Receptionist")) {

            add.setVisible(false);
            delete.setVisible(false);

        }

        add.addActionListener(e -> {
            service.addRoom(Integer.parseInt(roomField.getText()));
            area.setText("Room Added");
        });

        book.addActionListener(e -> {
            area.setText(service.bookRoom(
                    Integer.parseInt(roomField.getText()),
                    guestField.getText()
            ));
        });

        out.addActionListener(e -> {
            area.setText(service.checkOut(
                    Integer.parseInt(roomField.getText())
            ));
        });

        show.addActionListener(e -> {
            area.setText(service.showRooms());
        });

        delete.addActionListener(e -> {
            area.setText(service.deleteRoom(
                    Integer.parseInt(roomField.getText())
            ));
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}