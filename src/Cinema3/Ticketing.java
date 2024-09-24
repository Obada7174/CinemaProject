//package Cinema3;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Ticketing{
//    private List<Cinema> cinemas;
//    private List<Movie> movies;
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }
//
//    public List<Cinema> getCinemas(){
//        return cinemas;
//    }
//
//    public void setCinemas(List<Cinema> cinemas) {
//        this.cinemas = cinemas;
//    }
//
//    public Ticketing() {
//        this.cinemas = new ArrayList<>();
//    }
//
//    public void addCinema(Cinema cinema) {
//        cinemas.add(cinema);
//    }
//
//    public void displayAvailableMovies() {
//        for (Cinema cinema : cinemas) {
//            System.out.println("Cinema: " + cinema.getName());
//            for (Movie movie : cinema.getMovies()) {
//                System.out.println("Movie: " + movie.getTitle());
//                System.out.println("Show times: " + movie.getShowTime());
//                System.out.println("---------------------");
//            }
//        }
//    }
//
//    public void displayAvailableSeats(Movie movie, String showtime) {
//        System.out.println("Movie: " + movie.getTitle());
//        System.out.println("Showtime: " + showtime);
//        System.out.println("Available Seats: ");
//        for (Seat seat : movie.getSeats()) {
//            if (seat.isAvailable()) {
//                System.out.println("Seat: " + seat.getSeatNumber());
//            }
//        }
//    }
//
//    public void reserveTicket(User user, Movie movie, String showtime, int seatNumber) {
//        Seat selectedSeat = null;
//        for (Seat seat : movie.getSeats()) {
//            if (seat.getSeatNumber() == seatNumber) {
//                selectedSeat = seat;
//                movie.getSeats().remove(seat);
//                break;
//            }
//        }
//
//        if (selectedSeat != null && selectedSeat.isAvailable()) {
//            selectedSeat.setAvailable(false);
//            Ticket ticket = new Ticket(seatNumber, movie.getTicketPrice() , movie,); // Assuming a fixed ticket price
//            user.addTicket(ticket);
//            System.out.println("Ticket reserved for " + user.getUsername() + " - Movie: " + movie.getTitle() +
//                    " - Showtime: " + showtime + " - Seat: " + seatNumber);
//        } else {
//            System.out.println("Seat " + seatNumber + " is not available for Movie: " + movie.getTitle() +
//                    " - Showtime: " + showtime);
//        }
//    }
//
//    public void cancelReservation(User user, Ticket ticket) {
//        if (user.getTickets().contains(ticket)) {
//            ticket.getSeat().setAvailable(true);
//            user.removeTicket(ticket);
//            System.out.println("Ticket canceled for " + user.getUsername() + " - Movie: " + ticket.getMovie().getTitle() +
//                    " - Showtime: " + ticket.getShowtime() + " - Seat: " + ticket.getSeat().getSeatNumber());
//        } else {
//            System.out.println("Ticket not found for " + user.getUsername());
//        }
//    }
//
//        public void displayReportsAndStatistics() {
//            int totalTicketsSold = 0;
//            double totalRevenue = 0.0;
//
//            System.out.println("----- Ticketing System Reports -----");
//
//            for (Cinema cinema : cinemas) {
//                System.out.println("Cinema: " + cinema.getName());
//                System.out.println("Movies:");
//
//                for (Movie movie : cinema.getMovies()) {
//                    int movieTicketsSold = 0;
//                    double movieRevenue = 0.0;
//
//                    System.out.println("  - Movie: " + movie.getTitle());
//
//                    for (Seat seat : movie.getSeats()) {
//                        if (!seat.isAvailable()) {
//                            movieTicketsSold++;
//                            movieRevenue += Integer.parseInt(movie.getTicketPrice());
//                        }
//                    }
//
//                    System.out.println("    Total Tickets Sold: " + movieTicketsSold);
//                    System.out.println("    Total Revenue: $" + movieRevenue);
//                    System.out.println();
//                    totalTicketsSold += movieTicketsSold;
//                    totalRevenue += movieRevenue;
//                }
//                System.out.println("----- Overall Statistics -----");
//                System.out.println("Total Tickets Sold: " + totalTicketsSold);
//                System.out.println("Total Revenue: $" + totalRevenue);
//            }
//        }
//    }
