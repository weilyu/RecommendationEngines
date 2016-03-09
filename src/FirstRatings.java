import edu.duke.FileResource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lvwei on 3/9/2016.
 */
public class FirstRatings {
    //load csv file to crate an ArrayList of type Movie with all the movie
    //data in file
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movieList = new ArrayList<>();
        FileResource fr = new FileResource("data/" + filename);
        for (CSVRecord record : fr.getCSVParser()) {
            Movie input = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
                    record.get("director"), record.get("country"), record.get("poster"), Integer.valueOf(record.get("minutes")));
            movieList.add(input);
        }
        return movieList;
    }

    //process records from csv file and return an ArrayList of type Rater
    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> raterList = new ArrayList<>();
        FileResource fr = new FileResource("data/" + filename);

        for (CSVRecord record : fr.getCSVParser()) {
            String rater_id = record.get("rater_id");
            String movie_id = record.get("movie_id");
            Double rating = Double.valueOf(record.get("rating"));
            int idx = raterIndex(raterList, rater_id);
            if (idx == -1) {
                Rater curRater = new Rater(rater_id);
                curRater.addRating(movie_id, rating);
                raterList.add(curRater);
            } else {
                Rater curRater = raterList.get(idx);
                curRater.addRating(movie_id, rating);
                raterList.set(idx, curRater);
            }
        }
        return raterList;
    }

    public int raterIndex(ArrayList<Rater> raterList, String rater_id) {
        for (int i = 0; i < raterList.size(); i++) {
            if (raterList.get(i).getID().equals(rater_id)) return i;
        }
        return -1;
    }

    public void tester() {
        ArrayList<Rater> r = loadRaters("ratings_short.csv");
        for (Rater rr : r) System.out.println(rr.numRatings());
    }
}
