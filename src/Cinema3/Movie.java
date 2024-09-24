package Cinema3;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

   public class Movie {
        private String movieId;
        private String title;
        private String description;
        private String duration;
        private String genre;
        private String ticketPrice;
        private String cinema1;
        private String cinema2;
        private String showTime;
        private List<Seat> seats;
        private String seatNum;
        private String img;

       public Movie(String title,String movieId, String description,String cinema1,String cinema2, String duration,String ticketPrice, String genre,String seatNum,String showTime,String img ) {
           this.movieId = movieId;
           this.title = title;
           this.img=img;
           this.description = description;
           this.cinema1 = cinema1;
           this.cinema2 = cinema2;
           this.duration = duration;
           this.genre = genre;
           this.ticketPrice = ticketPrice;
           this.showTime = showTime;
           this.seats = new ArrayList<>();
           int sn = Integer.parseInt(seatNum);
           for (int i=1;i<sn;i++){
               Seat s = new Seat(i);
               seats.add(s);
           }

       }

       public String getShowTime() {
           return showTime;
       }

       public String getImg() {return img;}

       public void setShowTime(String showTime) {
           this.showTime = showTime;
       }

       public String getSeatNum() {
           return seatNum;
       }

       public void setSeatNum(String seatNum) {
           this.seatNum = seatNum;
       }

       public String getCinema1() {return cinema1;}

       public void setCinema1(String cinema1) {this.cinema1 = cinema1;}

       public String getCinema2() {return cinema2;}

       public void setCinema2(String cinema2) {this.cinema2 = cinema2;}

       public String getDescription() {
           return description;
       }

       public void setDescription(String description) {
           this.description = description;
       }

       public String getDuration() {
           return duration;
       }

       public void setDuration(String duration) {
           this.duration = duration;
       }

       public String getTicketPrice() {
           return ticketPrice;
       }

       public void setTicketPrice(String ticketPrice) {
           this.ticketPrice = ticketPrice;
       }

       public String getMovieId() {
           return movieId;
       }

       public void setMovieId(String movieId) {
           this.movieId = movieId;
       }

       public String getTitle() {
           return title;
       }

       public void setTitle(String title) {
           this.title = title;
       }

       public String getGenre() {
           return genre;
       }

       public void setGenre(String genre) {
           this.genre = genre;
       }

       public void setSeats(List<Seat> seats) {
           this.seats = seats;
       }

        public void addSeat(Seat seat) {
            seats.add(seat);
        }

        public List<Seat> getSeats() {
            return seats;
        }
    }


