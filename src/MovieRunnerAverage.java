/**
 * Created by lvwei on 4/1/2016.
 */
public class MovieRunnerAverage {
    public void printAverageRatings() {
        SecondRatings sr = new SecondRatings("ratedmovies_short.csv", "ratings_short.csv");
        System.out.println("The number of movies is " + sr.getMovieSize());
        System.out.println("The number of raters is " + sr.getRaterSize());

    }
}
