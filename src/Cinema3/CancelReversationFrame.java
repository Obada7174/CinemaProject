package Cinema3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CancelReversationFrame extends JFrame {
    private JTextField seatNumberField;
    private JComboBox<String> cinemaComboBox;

    public CancelReversationFrame(User user, Movie movie, JFrame frame2) {
        setTitle("Cancel Reservation ");
        setSize(400, 200);
        setLayout(null);

        JLabel seatLabel = new JLabel("Seat Number : ");
        seatLabel.setBounds(20, 20, 100, 20);
        seatNumberField = new JTextField();
        seatNumberField.setBounds(130, 20, 200, 20);

        JLabel cinemaLabel = new JLabel("Cinema :");
        cinemaLabel.setBounds(20, 50, 100, 20);

        // قائمة المحتوى لل ComboBox
        String[] cinemaOptions = {movie.getCinema1(), movie.getCinema2()};
        cinemaComboBox = new JComboBox<>(cinemaOptions);
        cinemaComboBox.setBounds(130, 50, 200, 20);

        JButton cancelReserveButton = new JButton("Cancel Reserve");
        cancelReserveButton.setBounds(150, 90, 150, 30);
        cancelReserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedSeatNumber = Integer.parseInt(seatNumberField.getText());
                String selectedCinema = (String) cinemaComboBox.getSelectedItem();
                cancelReservation(user, movie, selectedSeatNumber, selectedCinema);
                dispose();
            }
        });

        add(seatLabel);
        add(seatNumberField);
        add(cinemaLabel);
        add(cinemaComboBox);
        add(cancelReserveButton);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void cancelReservation(User user, Movie movie, int seatNumber, String cinema) {
        Iterator<Ticket> iterator = user.getTickets().iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getMovie().getTitle().equals(movie.getTitle()) && ticket.getSeatNumber() == seatNumber && cinema.equals(ticket.getCinema())) {
                Seat selectedSeat = ticket.getSeat();
                if (selectedSeat != null) {
                    selectedSeat.setAvailable(true);
                    JOptionPane.showMessageDialog(null, "Ticket canceled for " + user.getUsername() +
                            " - Movie: " + ticket.getMovie().getTitle() +
                            " - Seat: " + ticket.getSeat().getSeatNumber() +
                            " -Cinema : " + ticket.getCinema());
                    iterator.remove();
                } else {
                    JOptionPane.showMessageDialog(null, "Selected seat is null for the ticket.");
                }
            }
        }
    }
}
