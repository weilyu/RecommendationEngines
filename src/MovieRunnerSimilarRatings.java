import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lvwei on 4/4/2016.
 */
public class MovieRunnerSimilarRatings {
    public void printAverageRatings() {
        FourthRatings sr = new FourthRatings("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("read data for " + RaterDatabase.size() + " raters");

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

    public void printAverageRatingsByYearAfterAndGenre() {
        FourthRatings sr = new FourthRatings("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("read data for " + RaterDatabase.size() + " raters");

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

    public void printSimilarRatings() {
        FourthRatings fr = new FourthRatings("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("read data for " + RaterDatabase.size() + " raters");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        String idToFind = "65";
        int minimalRaters = 5;
        int numSimilarRaters = 20;

        System.out.println("printSimilarRatings");
        System.out.println(MovieDatabase.getTitle(fr.getSimilarRatings(idToFind, numSimilarRaters, minimalRaters).get(0).getItem()));
        System.out.println("\n");
    }

    public void printSimilarRatingsByGenre() {
        FourthRatings fr = new FourthRatings("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("read data for " + RaterDatabase.size() + " raters");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        String idToFind = "65";
        int minimalRaters = 5;
        int numSimilarRaters = 20;
        Filter f = new GenreFilter("Action");

        System.out.println("printSimilarRatingsByGenre");
        System.out.println(MovieDatabase.getTitle(fr.getSimilarRatingsByFilter(idToFind, numSimilarRaters, minimalRaters, f).get(0).getItem()));
        System.out.println("\n");
    }

    public void printSimilarRatingsByDirector() {
        FourthRatings fr = new FourthRatings("ratings.csv");

        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("read data for " + RaterDatabase.size() + " raters");

        System.out.println("read data for " + MovieDatabase.size() + " movies");

        String idToFind = "1034";
        int minimalRaters = 3;
        int numSimilarRaters = 10;
        Filter f = new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone");

        System.out.println("printSimilarRatingsByDirector");
        System.out.println(MovieDatabase.getTitle(fr.getSimilarRatingsByFilter(idToFind, numSimilarRaters, minimalRaters, f).get(0).getItem()));
        System.out.println("\n");
    }
}
