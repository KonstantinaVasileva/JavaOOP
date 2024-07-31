package OOP.Polymorphism.Exercise.VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    protected void driveNonEmpty(double distance) {
        setFuelConsumption(getFuelConsumption() + 1.4);
        super.drive(distance);
    }
}
