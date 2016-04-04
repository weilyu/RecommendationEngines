import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lvwei on 4/4/2016.
 */
public class MovieRunnerWithFilters {
    public void printAverageRatings() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 35;

        //print a list of movies and their average ratings
        //for all those movies that have at least a
        //specified number of ratings, sorted by averages, lowest rating to highest rating
        //one movie per line (print its rating first, followed by its title)
        ArrayList<Rating> averageRatings = sr.getAverageRatings(minimalRaters);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByYear() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 20;

        Filter f = new YearAfterFilter(2000);

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 20;

        Filter f = new GenreFilter("Comedy");

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getGenres((r.getItem())));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 5;

        Filter f = new MinutesFilter(105, 135);

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + "Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByDirectors() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 4;

        Filter f = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getDirector(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 8;

        AllFilters f = new AllFilters();
        f.addFilter(new YearAfterFilter(1990));
        f.addFilter(new GenreFilter("Drama"));

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getDirector(r.getItem()));
        }
        System.out.println("\n");
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        ThirdRatings sr = new ThirdRatings("ratings.csv");

        System.out.println("read data for " + sr.getRaterSize() + " raters");

        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 3;

        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(90, 180));
        f.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));

        ArrayList<Rating> averageRatings = sr.getAverageRatingsByFilter(minimalRaters, f);
        System.out.println("found " + averageRatings.size() + " movies");

        Collections.sort(averageRatings);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + "Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem())
            + " " + MovieDatabase.getDirector(r.getItem()));
        }
        System.out.println("\n");
    }
}
