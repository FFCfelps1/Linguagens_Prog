public class Triangle extends TwoDimensionalShape {
    private double base, height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public double getPerimeter() {
        // Supondo triângulo equilátero
        return 3 * base;
    }

    @Override
    public void show() {
        System.out.println("Triangle: base=" + base + ", height=" + height);
        System.out.println("Area=" + getArea());
        System.out.println("Perimeter=" + getPerimeter());
    }
}
