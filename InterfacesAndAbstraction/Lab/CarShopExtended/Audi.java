package OOP.InterfacesAndAbstraction.Lab.CarShopExtended;

public class Audi extends CarImpl implements Rentable {
    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {

        return "%s%n Minimum rental period of %d days. Price per day %f "
                .formatted(super.toString(), getMinRentDay(), getPricePerDay());

    }

    @Override
    public Integer getMinRentDay() {
        return null;
    }

    @Override
    public Double getPricePerDay() {
        return null;
    }
}
