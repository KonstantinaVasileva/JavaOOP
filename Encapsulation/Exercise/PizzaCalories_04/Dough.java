package OOP.Encapsulation.Exercise.PizzaCalories_04;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Homemade") && !bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double floreTypeCoefficient = switch (flourType) {
            case "White" -> 1.5;
            case "Wholegrain" -> 1;
            default -> 0;
        };
        double bakingCoefficient = switch (bakingTechnique) {
            case "Homemade" -> 1;
            case "Crispy" -> 0.9;
            case "Chewy" -> 1.1;
            default -> 0;
        };
        return 2 * floreTypeCoefficient * bakingCoefficient * weight;
    }
}
