import java.util.ArrayList;

/**
 * Created by lvwei on 4/4/2016.
 */
public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsFile);
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

}
