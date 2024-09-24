package Cinema3;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static List<Movie> readMovies(String filePath) {
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                Movie movie = new Movie(data[0], data[1], data[2],data[3],data[4],data[5],data[6], data[7],data[8],data[9],data[10]);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public static Map<String, List<String>> readCinemasAndFilms(String filePath) {
        Map<String, List<String>> cinemas = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String cinema = parts[0].trim();
                String[] movie = parts[1].split(";");
                int i = 0;
                for (String moviePart : movie) {
                    String movie1 = moviePart.trim();
                    cinemas.computeIfAbsent(cinema, k -> new ArrayList<>()).add(movie1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cinemas;
    }

    //________________________________________________________________________________________________________________
    public static void main(String[] args) {
         String l = "src/Cinema3/movies.csv";
        List<Movie> movies2 = readMovies(l);

        String l2 = "src/Cinema3/cinemas.csv";
        Map<String, List<String>> cinemas = readCinemasAndFilms(l2);

        GUI gui = new GUI((ArrayList<Movie>) movies2,(HashMap<String, List<String>>) cinemas);


    }
}
