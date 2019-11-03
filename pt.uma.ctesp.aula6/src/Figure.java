import java.util.ArrayList;

public class Figure {
    private ArrayList shapes;

    public Figure() {
        this.shapes = new ArrayList();
    }

    public Figure(ArrayList shapes) {
        this.shapes = shapes;
    }

    public ArrayList getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList shapes) {
        this.shapes = shapes;
    }
}
