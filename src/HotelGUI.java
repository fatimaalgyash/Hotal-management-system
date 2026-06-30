import javax.swing.*;

/**
        * This class creates the graphical user interface (GUI)
        * for the Hotel Management System.
        */
public class HotelGUI {

    /**
            * Creates the GUI based on the user role.
            *
            * @param role user role (Admin or Receptionist)
     */
    public HotelGUI(String role) {

        HotelService service = new HotelService();

        JFrame frame = new JFrame("Hotel System");
        frame.setSize(500, 450);
        frame.setLayout(null);

        JLabel roomLabel = new JLabel("Room ID");
        roomLabel.setBounds(20, 20, 80, 25);
        frame.add(roomLabel);

        JTextField roomField = new JTextField();
        roomField.setBounds(120, 20, 150, 25);
        frame.add(roomField);

        JLabel guestLabel = new JLabel("Guest");
        guestLabel.setBounds(20, 60, 80, 25);
        frame.add(guestLabel);

        JTextField guestField = new JTextField();
        guestField.setBounds(120, 60, 150, 25);
        frame.add(guestField);

        JLabel typeLabel = new JLabel("Type");
        typeLabel.setBounds(20, 100, 80, 25);
        frame.add(typeLabel);

        JTextField typeField = new JTextField();
        typeField.setBounds(120, 100, 150, 25);
        frame.add(typeField);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(20, 140, 80, 25);
        frame.add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(120, 140, 150, 25);
        frame.add(priceField);

        JTextArea area = new JTextArea();
        area.setBounds(20, 260, 440, 120);
        frame.add(area);

        JButton add = new JButton("Add Room");
        add.setBounds(20, 190, 120, 30);
        frame.add(add);

        JButton update = new JButton("Update");
        update.setBounds(300, 190, 120, 30);
        frame.add(update);

        JButton delete = new JButton("Delete");
        delete.setBounds(20, 225, 120, 30);
        frame.add(delete);

        JButton book = new JButton("Book");
        book.setBounds(20, 225, 120, 30);
        frame.add(book);

        JButton checkout = new JButton("CheckOut");
        checkout.setBounds(160, 225, 120, 30);
        frame.add(checkout);

        JButton show = new JButton("Show");
        show.setBounds(300, 225, 120, 30);
        frame.add(show);

        // صلاحيات المستخدم
        if (role.equalsIgnoreCase("Admin")) {

            guestLabel.setVisible(false);
            guestField.setVisible(false);

            book.setVisible(false);
            checkout.setVisible(false);

        } else if (role.equalsIgnoreCase("Receptionist")) {

            add.setVisible(false);
            update.setVisible(false);
            delete.setVisible(false);

            typeLabel.setVisible(false);
            typeField.setVisible(false);

            priceLabel.setVisible(false);
            priceField.setVisible(false);
        }

        // Add Room
        add.addActionListener(e -> {
                    service.addRoom(
                            Integer.parseInt(roomField.getText()),
                            typeField.getText(),
                            Double.parseDouble(priceField.getText())
                    );

                    area.setText("Room Added!");
                });
            // Update Room
            update.addActionListener(e -> {

                area.setText(service.updateRoom(
                        Integer.parseInt(roomField.getText()),
                        typeField.getText(),
                        Double.parseDouble(priceField.getText())
                ));
            });

            // Delete Room
            delete.addActionListener(e -> {

                area.setText(service.deleteRoom(
                        Integer.parseInt(roomField.getText())
                ));
            });

            // Book Room
            book.addActionListener(e -> {

                area.setText(service.bookRoom(
                        Integer.parseInt(roomField.getText()),
                        guestField.getText()
                ));
            });

            // Check Out
            checkout.addActionListener(e -> {area.setText(service.checkOut(
                    Integer.parseInt(roomField.getText())
            ));
            });

            // Show Rooms
            show.addActionListener(e -> {

                area.setText(service.showRooms());

            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }


