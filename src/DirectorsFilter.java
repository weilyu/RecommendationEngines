/**
 * Created by lvwei on 4/4/2016.
 */
public class DirectorsFilter implements Filter {
    private String[] dirs;

    public DirectorsFilter(String dir) {
        this.dirs = dir.split(",");
    }

    @Override
    public boolean satisfies(String id) {
        for (String dir : dirs) {
            if (MovieDatabase.getDirector(id).contains(dir)) return true;
        }
        return false;
    }
}
