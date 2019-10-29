public abstract class Vehicle {
    private int year,price;
    private String brand,model, color;

    public Vehicle() {
    }

    public Vehicle(int year, int price, String brand, String model, String color) {
        this.year = year;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return ("Year: " + year + " price: " + price + " brand: " + brand + " model: " + model + " color: " + color);
    }
}
