public class main {
    public static void main(String[] args) {
        Vehicle car = new Car(2009, 15000, "Ferrari", "f40", "red", 2);
        System.out.println(car.toString());
        Vehicle mota = new Motorcycle(2009, 11000, "Yamaha", "r1", "blue", 25);
        System.out.println(mota.toString());
        Point point = new Point(1, 1);
        Shape circle = new Circle(point, 2);
        System.out.println(circle.getPerimeter());
        Figure figure = new Figure();
        figure.addShape(circle);

    }
}
