package car;

public class Car {
    
    private String model;
    private int year;
    private int speed;

    public Car (String model, int year, int speed) {
        this.model = model;
        this.year = year;
        this.speed = speed;
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Car() {
        this("소나타", 2023);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + ", speed=" + speed + "]";
    }
    
    
    
}
