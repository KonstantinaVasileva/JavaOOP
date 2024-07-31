package OOP.Polymorphism.Exercise.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void drive(double distance) {
        double v = fuelQuantity - distance * fuelConsumption;
        if (v >= 0) {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(v);
            System.out.println("%s travelled %s km".formatted(this.getClass().getSimpleName(), df.format(distance)));
        } else {
            System.out.println("%s needs refueling".formatted(this.getClass().getSimpleName()));
        }
    }
    protected void refuel(double fuel){
        fuelQuantity += fuel;
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), fuelQuantity);
    }
}
