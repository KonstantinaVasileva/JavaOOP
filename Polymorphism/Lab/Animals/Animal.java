package OOP.Polymorphism.Lab.Animals;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    protected Animal(String name, String favoriteFood) {
        setName(name);
        setFavoriteFood(favoriteFood);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s", name, favoriteFood);
    }
}
