import java.util.ArrayList;

/**
 * Created by lvwei on 4/1/2016.
 */
public class MovieRunnerAverage {
    public void printAverageRatings() {
        SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        System.out.println("The number of movies is " + sr.getMovieSize());
        System.out.println("The number of raters is " + sr.getRaterSize());

        //print a list of movies and their average ratings
        //for all those movies that have at least a
        //specified number of ratings, sorted by averages, lowest rating to highest rating
        //one movie per line (print its rating first, followed by its title)
        ArrayList<Rating> averageRatings =  sr.getAverageRatings(3);
        for (Rating r : averageRatings) {
            System.out.println(r.getValue() + " " + sr.getTitle(r.getItem()));
        }
    }
}
