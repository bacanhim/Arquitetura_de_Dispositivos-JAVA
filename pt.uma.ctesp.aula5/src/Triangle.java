public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
        Point a = new Point();
        Point b = new Point();
        Point c = new Point();
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getC() {
        return c;
    }

    public Point getB() {
        return b;
    }

    public Point getA() {
        return a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void setABC(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateWidth() {

        return b.distanceTo(c);
    }

    public double calculateHeight() {

        return b.distanceTo(a);
    }

    public double calcularArea() {
        return ((calculateWidth() * calculateHeight()) / 2);
    }
}
