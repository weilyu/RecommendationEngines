import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lvwei on 4/4/2016.
 */
public class MovieRunnerWithFilters {
    public void printAverageRatings() {
        ThirdRatings sr = new ThirdRatings("ratings_short.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmovies_short.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;

        //print a list of movies and their average ratings
        //for all those movies that have at least a
        //specified number of ratings, sorted by averages, lowest rating to highest rating
        //one movie per line (print its rating first, followed by its title)
        ArrayList<Rating> averageRatings =  sr.getAverageRatings(minimalRaters);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByYear() {
        ThirdRatings sr = new ThirdRatings("ratings_short.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmovies_short.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;

        Filter f = new YearAfterFilter(2000);

        ArrayList<Rating> averageRatings =  sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings sr = new ThirdRatings("ratings_short.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmovies_short.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;

        Filter f = new GenreFilter("Crime");

        ArrayList<Rating> averageRatings =  sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getGenres((r.getItem())));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings sr = new ThirdRatings("ratings_short.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmovies_short.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;

        Filter f = new MinutesFilter(110, 170);

        ArrayList<Rating> averageRatings =  sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " "+ "Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }
}
