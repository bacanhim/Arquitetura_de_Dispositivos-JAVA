public class Point {
    private double x, y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    public void setX(final double x) {
        this.x=x;
    }
    public void setY(final double y) {
        this.y=y;
    }

    public void setXY(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x-this.x,2)+Math.pow(other.y-this.y, 2));
    }
}
