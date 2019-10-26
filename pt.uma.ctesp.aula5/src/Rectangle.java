public class Rectangle {
    private Point topLeftPoint;
    private double height, width;

    public Rectangle() {
        topLeftPoint = new Point();
        height = 0;
        width = 0;
    }
    public Rectangle(Point topLeftPoint, double width, double height) {
        this.topLeftPoint = topLeftPoint;
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setTopLeftPoint(Point topLeftPoint) {
        this.topLeftPoint = topLeftPoint;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public void setAll(Point topLeftPoint, double width, double height) {
        this.width = width;
        this.height = height;
        this.topLeftPoint = topLeftPoint;
    }

    public double calculateAreaRectangle() {
        return width*height;
    }

    public double calculatePerimeterRectangle() {
        return (width*2)+(height*2);
    }
}
