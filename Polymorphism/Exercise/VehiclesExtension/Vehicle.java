package OOP.Polymorphism.Exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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

    protected void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (fuelQuantity + fuel > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            fuelQuantity += fuel;
        }
    }

    @Override
    public String toString() {
        return "%s: %.2f".formatted(this.getClass().getSimpleName(), fuelQuantity);
    }
}
