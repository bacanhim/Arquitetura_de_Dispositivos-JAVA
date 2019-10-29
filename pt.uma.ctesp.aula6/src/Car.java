public class Car extends Vehicle {
    private int door;

    public Car() {
        super();
        this.door = 0;
    }

    public Car(int year, int price, String brand, String model, String color, int door) {
        super(year, price, brand, model, color);
        this.door = door;
    }

    @Override
    public String toString() {
        return "Isto e um carro de " + door + " portas " + super.toString();
    }
}
