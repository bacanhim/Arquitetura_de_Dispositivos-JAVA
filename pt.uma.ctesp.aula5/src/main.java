public class main {
    public static void main(String[] args) {
        Point a = new Point(0, 3
        );
        Point b = new Point(1, 1);
        Point c = new Point(3, 1);
//        System.out.println(a.distanceTo(b));
        Triangle z = new Triangle(a, b, c);
        Rectangle s = new Rectangle(a, 5, 3);
        System.out.println(s.pointInsideRectangle(c));

    }
}
