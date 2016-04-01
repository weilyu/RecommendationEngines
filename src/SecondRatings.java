
/**
 * Write a description of SecondRatings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    public SecondRatings(String movieFile, String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(movieFile);
        myRaters = fr.loadRaters(ratingsFile);
    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    //returns a double representing the average movie rating for
    //this ID if there are at least minimalRaters ratings
    public double getAverageByID(String id, int minimalRaters) {
        //count ratings number of this movie ID
        int count = 0;
        for (Rater r : myRaters) {
            if (r.hasRating(id)) count++;
        }

        //if count is larger of equal to minimalRaters, do the average math
        double sum = 0;
        if (count >= minimalRaters) {
            for (Rater r : myRaters) {
                sum += r.getRating(id);
            }
            return sum / count;
        }

        return 0.0;
    }

}
