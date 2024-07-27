package OOP.Polymorphism.Lab.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    double calculateArea() {
        return height * width;
    }
}
