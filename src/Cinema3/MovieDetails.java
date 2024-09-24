package Cinema3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDetails {
    public MovieDetails(JFrame frame2, Movie movie,User currentUser) {

        JFrame frame = new JFrame("Movie details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 540);

        ImageIcon imageIcon = new ImageIcon("src/Cinema3/logo.png");

        ImageIcon smallIcon = new ImageIcon(movie.getImg());
        Image image = smallIcon.getImage();
        JPanel mainPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                g2d.drawImage(image, 30, 50, this);

                g2d.dispose();
            }
        };
//        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 960, 350);
        mainPanel.setBackground(new Color(0x411218));

//        JLabel smallLabel = new JLabel();
//        ImageIcon smallIcon = new ImageIcon(movie.getImg());
//        smallLabel.setIcon(smallIcon);
//        smallLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
//        smallLabel.setBounds(0, 0, 300, 350);
//        smallLabel.setForeground(Color.WHITE);


//        JLabel smallLabel = new JLabel();
//        ImageIcon smallIcon = new ImageIcon(movie.getImg());
//        Image image = smallIcon.getImage();
//        smallIcon = new ImageIcon(image);
//
//        smallLabel.setIcon(smallIcon);
//        smallLabel.setBounds(0, 0, 350, mainPanel.getHeight());
//        smallLabel.setVerticalAlignment(JLabel.CENTER);  // يوسع الصورة بشكل عمودي لتتناسب مع ارتفاع mainPanel

        JLabel title = createLabel("Movie Title :", 350, 10, mainPanel);
        JLabel movieId = createLabel("Movie ID :", 350, 40, mainPanel);
        JLabel duration = createLabel("Duration :", 350, 70, mainPanel);
        JLabel genre = createLabel("Genre :", 350, 100, mainPanel);
        JLabel ticketPrice = createLabel("Ticket Price :", 350, 130, mainPanel);
        JLabel cinemasAvailable = createLabel("Cinemas : ",350,160,mainPanel);
        JLabel description = createLabel("Description :", 350, 190, mainPanel);

        JLabel titleV = createLabel(movie.getTitle(), 500, 10, mainPanel);
        JLabel movieIdV = createLabel(movie.getMovieId(), 500, 40, mainPanel);
        JLabel durationV = createLabel(movie.getDuration(), 500, 70, mainPanel);
        JLabel genreV = createLabel(movie.getGenre(), 500, 100, mainPanel);
        JLabel ticketPriceV = createLabel(movie.getTicketPrice(), 500, 130, mainPanel);
        JLabel cinemasAvailableV = createLabel(movie.getCinema1()+"  "+movie.getCinema2(), 500, 160, mainPanel);

        JTextArea descriptionTextArea = new JTextArea(movie.getDescription());
        descriptionTextArea.setBounds(500, 190, 400, 170);
        descriptionTextArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        descriptionTextArea.setForeground(Color.WHITE);
        descriptionTextArea.setBackground(new Color(0x411218));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setFocusable(false);
        mainPanel.add(descriptionTextArea);

//        mainPanel.add(smallLabel);

        JPanel bottomPanel = new JPanel(null);
        bottomPanel.setBounds(0, 310, 960, 220);
        bottomPanel.setBackground(Color.BLACK);

        JLabel showTimes = createLabel("Show Time : "+movie.getShowTime(), 350, 20, bottomPanel);
        showTimes.setForeground(new Color(12089638));
        JLabel seats = new JLabel("Seats : ");
        seats.setBounds(350,45,100,50);
        seats.setBackground(bottomPanel.getBackground());
        seats.setForeground(showTimes.getForeground());
        seats.setFont(showTimes.getFont());
        int seatCount = 0;
        JTextArea seatsArea = new JTextArea();
        seatsArea.setPreferredSize(new Dimension(400,movie.getSeats().size()*11/10));
        seatsArea.setEditable(false);
        seatsArea.setFocusable(false);
        seatsArea.setFont(new Font("Helvetica", Font.PLAIN,12));
        seatsArea.setBackground(bottomPanel.getBackground());
        seatsArea.setForeground(new Color(12089638));
        bottomPanel.add(seats);

        JScrollPane scrollPane = new JScrollPane(seatsArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(430, 60, 445, 120);

        bottomPanel.add(scrollPane);

        seatsArea.setLineWrap(true);
        seatsArea.setWrapStyleWord(true);

        for (Seat s : movie.getSeats()) {
            seatsArea.append(s.getSeatNumber() + "   ");
            seatCount++;
        }

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        reserveButton.setBounds(120, 0, 180, 200);
        reserveButton.setForeground(new Color(4264472));
        reserveButton.setBackground(new Color(12089638));
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                new ReversationFrame(currentUser, movie, frame2);

            }
        });

        JButton backButton = new JButton("Back");
        backButton.setForeground(new Color(12089638));
        backButton.setBackground(new Color(000000));
        backButton.setBounds(0, 0, 80, 50);
        backButton.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                frame2.setVisible(true);
                frame.setVisible(false);
            }
        });

        JButton cancelReservationButton = new JButton("<html>Cancel<br>Reserve</html>");
        cancelReservationButton.setForeground(new Color(4264472));
        cancelReservationButton.setBackground(new Color(12089638));
        cancelReservationButton.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        cancelReservationButton.setBounds(0, 0, 110, 200);
        cancelReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CancelReversationFrame(currentUser, movie, frame);

            }
        });


        mainPanel.add(backButton);
        bottomPanel.add(cancelReservationButton);
        bottomPanel.add(showTimes);
        bottomPanel.add(reserveButton);
        bottomPanel.add(seats);

        frame.setIconImage(imageIcon.getImage());
        frame.add(bottomPanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 280, 20);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);
        return label;
    }
}
