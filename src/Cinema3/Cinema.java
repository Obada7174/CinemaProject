package Cinema3;
import java.util.ArrayList;
import java.util.List;
public class Cinema {
    private String name;
    private List<Movie> movies;

    public Cinema(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
