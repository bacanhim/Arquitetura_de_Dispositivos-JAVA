import java.util.ArrayList;

public class ShowList {
    ArrayList<TVShow> TVshowList;

    public ShowList() {
        TVshowList = new ArrayList<TVShow>();
    }

    public void ordenar() {
        TVshowList.sort(new Comparador());
    }

    public void add(TVShow show) {
        TVshowList.add(show);
    }
}
