import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by lvwei on 4/4/2016.
 */
public class FourthRatings {

    public FourthRatings() {
        // default constructor
        this("ratings.csv");
    }

    public FourthRatings(String ratingsFile) {
    }

    //returns a double representing the average movie rating for
    //this ID if there are at least minimalRaters ratings
    public double getAverageByID(String id, int minimalRaters) {
        //count ratings number of this movie ID
        int count = 0;
        for (Rater r : RaterDatabase.getRaters()) {
            if (r.hasRating(id)) count++;
        }

        //if count is larger of equal to minimalRaters, do the average math
        double sum = 0;
        if (count >= minimalRaters) {
            for (Rater r : RaterDatabase.getRaters()) {
                double curAverage = r.getRating(id);
                if (curAverage >= 0) {
                    sum += r.getRating(id);
                }
            }
            return sum / count;
        }

        return 0.0;
    }

    //return an ArrayList
    //of all the Rating objects for movies that have at least the minimal number of raters
    public ArrayList<Rating> getAverageRatings(int minimalRaters) {

        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        ArrayList<Rating> output = new ArrayList<>();
        for (String id : movies) {
            double curAverage = getAverageByID(id, minimalRaters);
            if (curAverage > 0) {
                Rating curRating = new Rating(id, curAverage);
                output.add(curRating);
            }
        }
        return output;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> output = new ArrayList<>();
        ArrayList<String> idsSatisfied = MovieDatabase.filterBy(filterCriteria);
        for (String id : idsSatisfied) {
            double average = getAverageByID(id, minimalRaters);
            if (average > 0) {
                Rating toAdd = new Rating(id, average);
                output.add(toAdd);
            }
        }
        return output;
    }

    //translate a rating from the scale 0 to 10 to the scale -5 to 5 and return the dot product of the ratings of movies that they both rated
    private double dotProduct(Rater me, Rater r) {
        double output = 0;
        for (String item : me.getItemsRated()) {
            if (r.hasRating(item)) {
                output += (5 - me.getRating(item)) * (5 - r.getRating(item));
            }
        }
        return output;
    }

    private ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> output = new ArrayList<>();

        RaterDatabase.getRaters().stream().filter(r -> !r.getID().equals(id)).forEach(r -> {
            double value = dotProduct(RaterDatabase.getRater(id), r);
            if (value > 0) {
                output.add(new Rating(r.getID(), value));
            }
        });

        Collections.sort(output, Collections.reverseOrder());
        return output;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        //get top numSimilarRaters of raters
        ArrayList<Rater> topRaters = getTopRaters(id, numSimilarRaters);

        //define output
        ArrayList<Rating> output = new ArrayList<>();

        //get movie list and number rated by top raters
        HashMap<n>
        for (Rating rater : topRaters) {
            String curRaterID = rater.getItem();
            ArrayList<String> itemRated = RaterDatabase.getRater(curRaterID).getItemsRated();
            for (itemRated)
        }

        //return Rating list of movies sorted by average rating from the largest to the smallest
        Collections.sort(output, Collections.reverseOrder());
        return output;
    }

    private ArrayList<Rater> getTopRaters(String id, int numSimilarRaters) {
        ArrayList<Rater> output = new ArrayList<>()
        ArrayList<Rating> allPositiveRaters = getSimilarities(id);
        for (int i = 0; i < numSimilarRaters; i++) {
            output.add(RaterDatabase.getRater(allPositiveRaters.get(i).getItem()));
        }
        return output;
    }
}
