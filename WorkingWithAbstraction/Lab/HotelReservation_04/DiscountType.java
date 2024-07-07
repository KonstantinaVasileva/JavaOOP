package OOP.WorkingWithAbstraction.Lab.HotelReservation_04;

public enum DiscountType {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);
    private int value;

    DiscountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DiscountType fromString(String discountType){
        return switch (discountType) {
            case "VIP" -> VIP;
            case "SecondVisit" -> SECOND_VISIT;
            case "None" -> NONE;
            default -> throw new IllegalArgumentException("Unknown discount type " + discountType);
        };
    }
}
