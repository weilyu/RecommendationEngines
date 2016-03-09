import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lvwei on 3/9/2016.
 */
public class FirstRatings {
    //load csv file to crate an ArrayList of type Movie with all the movie
    //data in file
    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movieList = new ArrayList<>();
        FileResource fr = new FileResource("data/" + filename);
        for (CSVRecord record : fr.getCSVParser()) {
            Movie input = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
                    record.get("director"), record.get("country"), record.get("poster"), Integer.valueOf(record.get("minutes")));
            movieList.add(input);
        }
        return movieList;
    }

    //process records from csv file and return an ArrayList of type Rater
    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> raterList = new ArrayList<>();
        FileResource fr = new FileResource("data/" + filename);

        for (CSVRecord record : fr.getCSVParser()) {
            String rater_id = record.get("rater_id");
            String movie_id = record.get("movie_id");
            Double rating = Double.valueOf(record.get("rating"));
            int idx = raterIndex(raterList, rater_id);
            if (idx == -1) {
                Rater curRater = new Rater(rater_id);
                curRater.addRating(movie_id, rating);
                raterList.add(curRater);
            } else {
                raterList.get(idx).addRating(movie_id, rating);
            }
        }
        return raterList;
    }

    //helper method to return the index
    private int raterIndex(ArrayList<Rater> raterList, String rater_id) {
        for (int i = 0; i < raterList.size(); i++) {
            if (raterList.get(i).getID().equals(rater_id)) return i;
        }
        return -1;
    }

    public void testLoadMovies() {
        //get the number of movies in the list
        ArrayList<Movie> movieList = loadMovies("ratedmovies_short.csv"); //modify the String to test on other file
        System.out.println("The number of movies is " + movieList.size());

        //how many movies included the genre
        String genre = "Comedy"; //can be modified
        int countGenre = 0;
        for (Movie m : movieList) {
            if (m.getGenres().contains(genre)) countGenre++;
        }
        System.out.println("The number of " + genre + " movies is " + countGenre);

        //how many movies are greater than the length
        int length = 150; //can be modified
        int countLength = 0;
        for (Movie m : movieList) {
            if (m.getMinutes() > length) countLength++;
        }
        System.out.println("The number of movies longer than " + length + " minutes is " + countLength);

        //find the max number of movies by any director
        //find who the directors are that direct that many movies
        HashMap<String, Integer> dirNumMap = new HashMap<>(); //key: director's name, value: movie numbers
        for (Movie m : movieList) {
            String[] dirList = m.getDirector().split(", ");
            for (String dir : dirList) {
                if (!dirNumMap.containsKey(dir)) {
                    dirNumMap.put(dir, 1);
                } else {
                    int v = dirNumMap.get(dir) + 1;
                    dirNumMap.put(dir, v);
                }
            }
        }
        int maxNum = 0;
        for (int n : dirNumMap.values()) {
            if (n > maxNum) maxNum = n;
        }
        System.out.println("The directors having the largest movie number are:");
        for (String dir : dirNumMap.keySet()) {
            if (dirNumMap.get(dir) == maxNum) System.out.println(dir);
        }
        System.out.println("--------------------------------------");
    }

    public void testLoadRaters() {
        ArrayList<Rater> raterList = loadRaters("ratings_short.csv");
        //return the number of raters
        System.out.println("The number of raters is " + raterList.size());

        //find the number of ratings for a particular rater
        String id = "2"; //can be modified
        raterList.stream().filter(r -> r.getID().equals(id)).forEach(r -> System.out.println("The number of ratings for rater id-"
                + id + " is " + r.getItemsRated().size()));

        //find the largest umber of ratings by any raters
        int maxRatings = 0;
        for (Rater r : raterList) {
            if (r.numRatings() > maxRatings) maxRatings = r.numRatings();
        }
        System.out.println("The largest umber of ratings by any raters is " + maxRatings);
        //raters who have the max number of ratings
        System.out.println("Raters who have the max number of ratings are");
        for (Rater r : raterList) {
            if (r.numRatings() == maxRatings) System.out.println(r.getID());
        }

        //find the number of ratings a particular movie has
        String movie_id = "1798709";
        int countRating = 0;
        for (Rater r : raterList) {
            if (r.hasRating(movie_id)) countRating++;
        }
        System.out.println("The number of ratings of movie id:" + movie_id + " is " + countRating);

        //determine how many different movies have been rated by all these raters
        HashSet<String> movieSet = new HashSet<>();
        for (Rater r : raterList) {
            ArrayList<String> curMovList = r.getItemsRated();
            curMovList.stream().filter(s -> !movieSet.contains(s)).forEach(movieSet::add);
        }
        System.out.println("The number of different movies rated is " + movieSet.size());
    }
}
