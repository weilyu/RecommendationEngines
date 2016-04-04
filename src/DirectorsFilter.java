/**
 * Created by lvwei on 4/4/2016.
 */
public class DirectorsFilter implements Filter {
    private String dir;

    public DirectorsFilter(String dir) {
        this.dir = dir;
    }

    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getDirector(id).contains(dir);
    }
}
