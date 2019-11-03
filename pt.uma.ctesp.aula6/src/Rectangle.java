import java.awt.*;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
        super();
        this.height = 0;
        this.height = 0;
    }

    public Rectangle(Point position, double width, double height) {
        super(position);
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return getHeight() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return getHeight() + getWidth() + getWidth() + getHeight();
    }
}
