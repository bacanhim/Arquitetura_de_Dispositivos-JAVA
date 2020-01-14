import java.util.Comparator;
public class Comparador implements Comparator<TVShow> {

    @Override
    public int compare(TVShow tvShow, TVShow t1) {
        return (int) (t1.getRating()-tvShow.getRating());
    }
}
