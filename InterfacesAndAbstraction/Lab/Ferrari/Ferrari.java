package OOP.InterfacesAndAbstraction.Lab.Ferrari;

public class Ferrari implements Car{
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return "%s/%s/%s/%s".formatted(model, brakes(), gas(), driverName);
    }
}
