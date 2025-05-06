public class Circle extends TwoDimensionalShape {
    private double radius;

    // Sobrecarga: construtor com int
    public Circle(int radius) {
        this.radius = radius;
    }

    // Sobrecarga: construtor com double
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void show() {
        System.out.println("Circle: radius=" + radius);
        System.out.println("Area=" + getArea());
        System.out.println("Perimeter=" + getPerimeter());
    }
}
