public class Motorcycle extends Vehicle {
    private double leanAngle;

    public Motorcycle() {
        super();
        leanAngle = 0;
    }

    public Motorcycle(int year, int price, String brand, String model, String color, double leanAngle) {
        super(year, price, brand, model, color);
        this.leanAngle = leanAngle;
    }

    @Override
    public String toString() {
        return "A mota tem um lean angle de: "+leanAngle+ "º "+super.toString();
    }
}
