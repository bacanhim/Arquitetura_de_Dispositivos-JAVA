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
        return width * height;
    }

    public double calculatePerimeterRectangle() {
        return (width * 2) + (height * 2);
    }

    public boolean pointInsideRectangle(Point point) {
        boolean boleano = false;
        Point topRightPoint = new Point(topLeftPoint.getX() + width, topLeftPoint.getY());
        Point bottomRightPoint = new Point(topRightPoint.getX() + width, topRightPoint.getY() - height);
        Point bottomLeftPoint = new Point(topRightPoint.getX(), topRightPoint.getY() - height);
        if (point.getX() > topLeftPoint.getX() && point.getX() < topRightPoint.getX() && point.getY() > bottomRightPoint.getY() && point.getY() < topRightPoint.getY()) {
            boleano = true;
        }
        return boleano;
    }



}
