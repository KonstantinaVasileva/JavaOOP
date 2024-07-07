package OOP.WorkingWithAbstraction.Lab.HotelReservation_04;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDay;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDay, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDay = numberOfDay;
        this.season = season;
        this.discountType = discountType;
    }

    public double totalPrice() {
        double totalPriceBeforeDiscount = this.pricePerDay * this.numberOfDay * this.season.getValue();
        double discount = totalPriceBeforeDiscount * this.discountType.getValue() / 100;
        return totalPriceBeforeDiscount - discount;
    }
}
