package Cinema3;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class GUI {
        public GUI(ArrayList<Movie> moviesList, HashMap<String, List<String>> cinemasList) {

            //___________________________Frame________________________________________________________________
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Main Page");
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);
            final User[] currentUser = {null};


            //__________________________________LeftPanel________________________________________________________________
            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(Color.BLACK);

            JButton topButton = new JButton("Available Movies");
            topButton.setBackground(new Color(8656408));
            topButton.setForeground(new Color(12089638));
            topButton.setBounds(0, 90, 200, 220);
            topButton.setFont(new Font(" Helvetica Neue", 1, 17));

            JButton bottomButton = new JButton("Available Cinemas");
            bottomButton.setBackground(new Color(8656408));
            bottomButton.setForeground(new Color(12089638));
            bottomButton.setBounds(0, 320, 200, 220);
            bottomButton.setFont(new Font(" Helvetica Neue", 1, 17));

            JButton userButton = new JButton("User Page");
            userButton.setBackground(new Color(4264472));
            userButton.setBounds(0, 0, 200, 90);
            userButton.setFont(new Font(" Helvetica Neue", 1, 20));
            userButton.setForeground(Color.WHITE);

            leftPanel.add(userButton);
            leftPanel.add(topButton);
            leftPanel.add(bottomButton);
            leftPanel.setBounds(0, 0, 200, 540);
            leftPanel.setLayout(null);
            leftPanel.setVisible(false);
//________________________________________pageTitle____________________________________________


            JLabel pageTitle = new JLabel("Choose & reserve Your Ticket");
            pageTitle.setFont(new Font(" Helvetica Neue", 1, 30));
            pageTitle.setBackground(new Color(66, 66, 66));
            pageTitle.setBounds(200, 0, 760, 80);
            pageTitle.setForeground(new Color(12089638));
            pageTitle.setHorizontalAlignment(0);
            pageTitle.setVerticalAlignment(0);
            //_______________________________________scroll panel 1 __________________________________

//            ImageIcon backgroundImageIcon = new ImageIcon("src/Cinema3/66440.jpg");
//            Image backgroundImage = backgroundImageIcon.getImage();

            JPanel moviePanel = new JPanel(null) ;
            moviePanel.setPreferredSize(new Dimension(760, 3300));
            moviePanel.setBackground(Color.LIGHT_GRAY);

            int i = -1;
            for(Movie m : moviesList) {
                i++;
                JLabel movieName = new JLabel("Movie Name");
                movieName.setBounds(10, 10 + i * 165, 120, 20);

                JLabel movieID = new JLabel("Movie ID");
                movieID.setBounds(10, 35 + i * 165, 120, 20);

                JLabel movieAvailableCinemas = new JLabel("Available Cinemas");
                movieAvailableCinemas.setBounds(10, 60 + i * 165, 120, 20);

                JLabel movieDuration = new JLabel("Movie Duration");
                movieDuration.setBounds(10, 85 + i * 165, 120, 20);

                JLabel movieTicketPrice = new JLabel("Ticket Price");
                movieTicketPrice.setBounds(10, 110 + i * 165, 120, 20);

                JLabel movieGenre = new JLabel("Movie Genre");
                movieGenre.setBounds(10, 135 + i * 165, 120, 20);

                JLabel separator = new JLabel("____________________________________________________________________________________________________________________________________________________________");
                separator.setBounds(0, 150 + i * 165, 740, 20);

                JLabel movieNameV = new JLabel(m.getTitle());
                movieNameV.setBounds(130, 10 + i * 165, 220, 20);

                JLabel movieIDV = new JLabel(m.getMovieId());
                movieIDV.setBounds(130, 35 + i * 165, 220, 20);

                JLabel movieAvailableCinemasV = new JLabel(m.getCinema1()+"  "+m.getCinema2());
                movieAvailableCinemasV.setBounds(130, 60 + i * 165, 220, 20);

                JLabel movieGenreV = new JLabel(m.getGenre());
                movieGenreV.setBounds(130, 135 + i * 165, 220, 20);
                JLabel movieTicketPriceV = new JLabel(m.getTicketPrice());
                movieTicketPriceV.setBounds(130, 110 + i * 165, 220, 20);
                JLabel movieDurationV = new JLabel(m.getDuration());
                movieDurationV.setBounds(130, 85 + i * 165, 220, 20);

                moviePanel.add(movieName);
                moviePanel.add(movieID);
                moviePanel.add(movieDuration);
                moviePanel.add(movieGenre);
                moviePanel.add(movieAvailableCinemas);
                moviePanel.add(movieTicketPrice);
                moviePanel.add(separator);

                moviePanel.add(movieNameV);
                moviePanel.add(movieDurationV);
                moviePanel.add(movieIDV);
                moviePanel.add(movieTicketPriceV);
                moviePanel.add(movieGenreV);
                moviePanel.add(movieAvailableCinemasV);

                JButton reserveButton = new JButton("Reserve Movie Ticket");
                reserveButton.setBackground(new Color(4264472));
                reserveButton.setBounds(420, 25 + i * 165, 190, 130);
                reserveButton.setFont(new Font(" Helvetica Neue", 1, 12));
                reserveButton.setForeground(Color.WHITE);
                reserveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        User currentUser2 = currentUser[0];
                        MovieDetails movieDetails = new MovieDetails(frame,m,currentUser[0]);
//                        movieDetails.setVisible(true);
                        frame.setVisible(false);
                    }
                });

                JButton cancelReserveButton = new JButton("<html>Cancel<br><br>Reserve</html>");
                cancelReserveButton.setBackground(new Color(12089638));
                cancelReserveButton.setBounds(620, 25 + i * 165, 100, 130);
                cancelReserveButton.setPreferredSize(new Dimension(100,130));
                cancelReserveButton.setFont(new Font(" Helvetica Neue", 1, 12));
                cancelReserveButton.setForeground(Color.BLACK);
                cancelReserveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new CancelReversationFrame(currentUser[0], m, frame);

                    }
                });

                moviePanel.add(reserveButton);
                moviePanel.add(cancelReserveButton);


            }

            JScrollPane movieScrollPanel1 = new JScrollPane(moviePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            movieScrollPanel1.setBounds(200, 90, 760, 450);
            movieScrollPanel1.setVisible(false);

            //__________________________________________________scroll Panel 2________________________________________________

            JPanel cinemaPanel = new JPanel(null);
            cinemaPanel.setLayout(null);
            cinemaPanel.setPreferredSize(new Dimension(760, 190*cinemasList.size()));
            cinemaPanel.setBackground(Color.LIGHT_GRAY);
            int x=-1;
            for (Map.Entry<String, List<String>> entry : cinemasList.entrySet()) {
                x++;
                JLabel cinemaName = new JLabel("Cinema Name");
                cinemaName.setBounds(20, 10 + x * 190, 120, 20);
                JLabel cinemaAvailableMovies = new JLabel("Available Movies");
                cinemaAvailableMovies.setBounds(20, 50 + x * 190, 120, 20);
                JLabel cinemaSeparator = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________");
                cinemaSeparator.setBounds(0, 165 + x * 190, 740, 20);
                JLabel cinemaNameV = new JLabel(entry.getKey());
                cinemaNameV.setBounds(160, 10 + x * 190, 220, 20);

                cinemaPanel.add(cinemaName);
                cinemaPanel.add(cinemaSeparator);
                cinemaPanel.add(cinemaAvailableMovies);
                cinemaPanel.add(cinemaNameV);

                List<String> availableMovies = entry.getValue();
                for (int j = 0, k = 0; j < availableMovies.size(); j++) {
                    JLabel availableMovie = new JLabel(availableMovies.get(j));
                    availableMovie.setForeground(Color.BLACK);
                    availableMovie.setCursor(Cursor.getPredefinedCursor(12));
                    availableMovie.addMouseListener(new MouseAdapter() {
                        public void mouseEntered(MouseEvent evt) {
                            availableMovie.setForeground(new Color(8656408));
                        }
                        public void mouseExited(MouseEvent evt) {
                            availableMovie.setForeground(Color.BLACK);
                        }
                        public void mouseClicked(MouseEvent evt) {
                            Movie selectedMovie = null;
                            for (Movie m1 :moviesList) {
                                if(m1.getTitle().equals(availableMovie.getText())){
                                     selectedMovie = m1;
                                }
                            }
                            User currentUser1 = currentUser[0];
                            MovieDetails movieDetails = new MovieDetails(frame,selectedMovie,currentUser1);
                            frame.setVisible(false);
                        }
                    });

                    availableMovie.setBounds(160, 50 + j * 25 + x * 190, 320, 20);
                    if (j > 4) {
                        availableMovie.setBounds(440, 50 + k * 25 + x * 190, 320, 20);
                        ++k;
                    }

                    cinemaPanel.add(availableMovie);
                }
            }

             JScrollPane movieScrollPanel2 = new JScrollPane(cinemaPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            movieScrollPanel2.setBounds(200, 90, 760, 450);
            movieScrollPanel2.setVisible(false);

            topButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    movieScrollPanel1.setVisible(true);
                    movieScrollPanel2.setVisible(false);
                }
            });
            bottomButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    movieScrollPanel2.setVisible(true);
                    movieScrollPanel1.setVisible(false);
                }
            });

            userButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    User currentUser0 = currentUser[0];
                    UserPage user = new UserPage(frame,currentUser0);
                    frame.setVisible(false);
                }
            });

//__________________________________________login panel______________________________________________________________________________________

            ImageIcon backgroundImageIcon1 = new ImageIcon("src/Cinema3/3387243.jpg");
            Image backgroundImage1 = backgroundImageIcon1.getImage();

            JPanel loginPanel = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage1, 0, 0, getWidth(), getHeight(), this);
                }
            };
            loginPanel.setBackground(new Color(0x411218));
            loginPanel.setBounds(0, 0, 760, 540);

            JLabel loginLabel = new JLabel("Enter Your Information");
            loginLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
            loginLabel.setBounds(250, 100, 300, 30);
            loginLabel.setForeground(new Color(0xffffff));

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            usernameLabel.setBounds(250, 150, 100, 20);
            usernameLabel.setForeground(new Color(0xffffff));

            JTextField usernameField = new JTextField();
            usernameField.setBounds(360, 145, 150, 30);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            passwordLabel.setBounds(250, 200, 100, 20);
            passwordLabel.setForeground(new Color(0xffffff));

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(360, 195, 150, 30);


            JButton loginButton = new JButton("Login");
            loginButton.setBackground(new Color(0xB87926));
            loginButton.setBounds(300, 250, 120, 40);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());

                    if (username.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Proceed with login
                        leftPanel.setVisible(true);
                        frame.setSize(980, 580);
                        movieScrollPanel1.setVisible(true);
                        loginPanel.setVisible(false);
                        currentUser[0] = new User(username, password);
                    }
                }
            });


            loginPanel.add(loginLabel);
            loginPanel.add(usernameLabel);
            loginPanel.add(usernameField);
            loginPanel.add(passwordLabel);
            loginPanel.add(passwordField);
            loginPanel.add(loginButton);



            // Add the login panel to the frame initially
            frame.add(loginPanel);
            frame.add(movieScrollPanel1);
            frame.add(movieScrollPanel2);
            frame.add(leftPanel);
            frame.add(pageTitle);
            frame.setSize(780, 580);
            frame.setVisible(true);
        }

    }

