/**
 * Created by lvwei on 4/1/2016.
 */
public class Test {
    public static void main(String[] args) {
//        MovieRunnerAverage mra = new MovieRunnerAverage();
//        mra.printAverageRatings();
//        mra.getAverageRatingOneMovie();
        MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
        mrwf.printAverageRatings();

        mrwf.printAverageRatingsByYear();

        mrwf.printAverageRatingsByGenre();

        mrwf.printAverageRatingsByMinutes();
    }
}
