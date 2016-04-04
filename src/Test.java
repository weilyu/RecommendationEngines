/**
 * Created by lvwei on 4/1/2016.
 */
public class Test {
    public static void main(String[] args) {
//        MovieRunnerAverage mra = new MovieRunnerAverage();
//        mra.printAverageRatings();
//        mra.getAverageRatingOneMovie();
        MovieRunnerWithFilters mrwf = new MovieRunnerWithFilters();
        System.out.println("printAverageRatings");
        mrwf.printAverageRatings();

        System.out.println("printAverageRatingsByYear");
        mrwf.printAverageRatingsByYear();

        System.out.println("printAverageRatingsByGenre");
        mrwf.printAverageRatingsByGenre();

        System.out.println("printAverageRatingsByMinutes");
        mrwf.printAverageRatingsByMinutes();

        System.out.println("printAverageRatingsByDirectors");
        mrwf.printAverageRatingsByDirectors();

        System.out.println("printAverageRatingsByYearAfterAndGenre");
        mrwf.printAverageRatingsByYearAfterAndGenre();

        System.out.println("printAverageRatingsByDirectorsAndMinutes");
        mrwf.printAverageRatingsByDirectorsAndMinutes();
    }
}
