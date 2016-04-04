import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lvwei on 4/3/2016.
 */
public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String, Rating> myRatings; //movie id, Rating associated with this movie

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<>();
    }

    public void addRating(String item, double rating) {
        myRatings.put(item, new Rating(item, rating));
    }

    //return true if this item is in myRatings, and false otherwise
    public boolean hasRating(String item) {
        return myRatings.containsKey(item);
    }

    public String getID() {
        return myID;
    }

    //return the double rating of this item if it is in myRatings, return -1 if not found
    public double getRating(String item) {
        if (hasRating(item)) return myRatings.get(item).getValue();
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    //return a list of all the items that have been rated
    public ArrayList<String> getItemsRated() {
        return (ArrayList<String>) myRatings.keySet();
    }
}
