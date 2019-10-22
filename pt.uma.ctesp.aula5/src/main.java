public class main {
    public static void main(String[] args) {
        Point a = new Point(1, 3);
        Point b = new Point(1, 1);
        Point c = new Point(3, 1);
//        System.out.println(a.distanceTo(b));
        Triangle z = new Triangle(a, b, c);
        System.out.println(z.calcularArea());
    }
}
