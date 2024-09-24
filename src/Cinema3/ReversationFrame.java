package Cinema3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReversationFrame extends JFrame {
    private JTextField seatNumberField;
    private JComboBox<String> cinemaComboBox;

    public ReversationFrame(User user, Movie movie, JFrame frame2) {

        setTitle("Reservation Information");
        setSize(400, 200);
        setLayout(null);


        JLabel seatLabel = new JLabel("Seat Number:");
        seatLabel.setBounds(20, 20, 100, 20);
        seatNumberField = new JTextField();
        seatNumberField.setBounds(130, 20, 200, 20);

        JLabel cinemaLabel = new JLabel("Cinema :");
        cinemaLabel.setBounds(20, 50, 100, 20);
        String[] cinemaOptions = {movie.getCinema1(), movie.getCinema2()};
        cinemaComboBox = new JComboBox<>(cinemaOptions);
        cinemaComboBox.setBounds(130, 50, 200, 20);

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setBounds(150, 90, 100, 30);
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedSeatNumber = Integer.parseInt(seatNumberField.getText());
                String selectedCinema = String.valueOf(cinemaComboBox.getSelectedItem());

                reserveTicket(user, movie, selectedSeatNumber,selectedCinema);


                JOptionPane.showMessageDialog(null, "Ticket Reserved for: " + movie.getTitle());

                dispose();

                frame2.setVisible(true);
            }
        });
        add(cinemaComboBox);
        add(cinemaLabel);
        add(seatLabel);
        add(seatNumberField);
        add(reserveButton);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void reserveTicket(User user, Movie movie, int seatNumber,String cinema) {
        Seat selectedSeat = null;
        for (Seat seat : movie.getSeats()) {
            if (seat.getSeatNumber() == seatNumber) {
                selectedSeat = seat;
                movie.getSeats().remove(seat);
                break;
            }
        }

        if (selectedSeat != null && selectedSeat.isAvailable()) {
            selectedSeat.setAvailable(false);
            Ticket ticket = new Ticket(seatNumber, movie.getTicketPrice(), movie,cinema);
            ticket.setSeat(selectedSeat);
            user.addTicket(ticket);
            System.out.println("Ticket reserved for " + user.getUsername() + " - Movie: " + movie.getTitle() +
                      " - Seat: " + seatNumber + "- Cinema : " + cinema);
        } else {
            System.out.println("Seat " + seatNumber + " is not available for Movie: " + movie.getTitle());
        }
    }
}

