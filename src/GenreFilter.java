/**
 * Created by lvwei on 4/4/2016.
 */
public class GenreFilter implements Filter {
    private String myGenre;

    public GenreFilter(String genre) {
        myGenre = genre;
    }

    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getGenres(id).contains(myGenre);
    }
}
