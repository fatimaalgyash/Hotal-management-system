import javax.swing.*;

public class HotelGUI {

    public HotelGUI(String role) {

        HotelService service = new HotelService();

        JFrame frame = new JFrame("Hotel System");
        frame.setSize(450, 450);
        frame.setLayout(null);

        JTextField roomField = new JTextField();
        roomField.setBounds(120, 20, 150, 25);
        frame.add(roomField);

        JTextField guestField = new JTextField();
        guestField.setBounds(120, 60, 150, 25);
        frame.add(guestField);

        JTextField typeField = new JTextField();
        typeField.setBounds(120, 100, 150, 25);
        frame.add(typeField);

        JTextField priceField = new JTextField();
        priceField.setBounds(120, 140, 150, 25);
        frame.add(priceField);

        JTextArea area = new JTextArea();
        area.setBounds(20, 250, 400, 150);
        frame.add(area);

        JButton add = new JButton("Add");
        add.setBounds(20, 200, 80, 30);
        frame.add(add);

        JButton update = new JButton("Update");
        update.setBounds(110, 200, 90, 30);
        frame.add(update);

        JButton delete = new JButton("Delete");
        delete.setBounds(210, 200, 90, 30);
        frame.add(delete);

        JButton book = new JButton("Book");
        book.setBounds(310, 200, 80, 30);
        frame.add(book);

        JButton checkout = new JButton("CheckOut");
        checkout.setBounds(20, 170, 120, 30);
        frame.add(checkout);

        JButton show = new JButton("Show");
        show.setBounds(150, 170, 120, 30);
        frame.add(show);

        // ===== صلاحيات =====

        if (role.equalsIgnoreCase("Admin")) {

            book.setVisible(false);
            checkout.setVisible(false);
            guestField.setVisible(false);

        } else if (role.equalsIgnoreCase("Receptionist")) {

            add.setVisible(false);
            update.setVisible(false);
            delete.setVisible(false);
            typeField.setVisible(false);
            priceField.setVisible(false);
        }

        // ===== Actions =====

        add.addActionListener(e -> {
            service.addRoom(Integer.parseInt(roomField.getText()));
            area.setText("Room Added");
        });

        update.addActionListener(e -> {
            area.setText(service.updateRoom(
                    Integer.parseInt(roomField.getText()),
                    typeField.getText(),
                    Double.parseDouble(priceField.getText())
            ));
        });

        delete.addActionListener(e -> {
            area.setText(service.deleteRoom(
                    Integer.parseInt(roomField.getText())
            ));
        });

        book.addActionListener(e -> {
            area.setText(service.bookRoom(
                    Integer.parseInt(roomField.getText()),
                    guestField.getText()
            ));
        });

        checkout.addActionListener(e -> {
            area.setText(service.checkOut(
                    Integer.parseInt(roomField.getText())
            ));
        });

        show.addActionListener(e -> {
            area.setText(service.showRooms());
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}