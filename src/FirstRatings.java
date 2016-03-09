import edu.duke.FileResource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by lvwei on 3/9/2016.
 */
public class FirstRatings {
    //load CSV file to crate an ArrayList of type Movie with all the movie
    //data in file
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movieList = new ArrayList<>();
        FileResource fr = new FileResource("data/" + filename);
        for (CSVRecord record : fr.getCSVParser()){
            Movie input = new Movie(record.get("id"), record.get("title"), record.get("year"),record.get("genre"),
                    record.get("director"), record.get("country"), record.get("poster"), Integer.valueOf(record.get("minutes")));
            movieList.add(input);
        }
        return movieList;
    }


    public void tester() {
        ArrayList<Movie> movieList = loadMovies("ratedmovies_short.csv");
        System.out.println(movieList.size());
        int count = 0;
        for (Movie m : movieList) {
            if (m.getMinutes() > 150) count++;
        }
        System.out.println(count);
    }
}
