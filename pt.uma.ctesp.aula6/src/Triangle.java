public class Triangle extends Shape {
    private double side;

    public Triangle() {
        super();
        this.side=0;
    }

    public Triangle(Point position, double side) {
        super(position);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public double getArea() {
        return (getSide() * getSide() / 2);
    }

    @Override
    public double getPerimeter() {
        return getSide() + getSide() + getSide();
    }
}
