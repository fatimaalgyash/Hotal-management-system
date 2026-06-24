import javax.swing.*;

public class HotelGUI {

    public HotelGUI() {

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

        frame.setVisible(true);
    }
}
