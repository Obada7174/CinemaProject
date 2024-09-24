package Cinema3;
import java.util.ArrayList;
import java.util.List;
public class Ticket {
    private int seatNumber;
    private String cinema;
    private String ticketPrice;
    private Movie movie;
    
    private Seat seat;

    public Ticket(int seatNumber, String ticketPrice,Movie movie,String cinema) {
        this.seatNumber = seatNumber;
        this.cinema = cinema;
        this.ticketPrice = ticketPrice;
        this.movie = movie;
        this.seat = null;

    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getCinema() {
        return cinema;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
