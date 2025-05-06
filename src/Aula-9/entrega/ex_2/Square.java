public class Square extends TwoDimensionalShape {
    private double side;

    public Square(int side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public void show() {
        System.out.println("Square: side=" + side);
        System.out.println("Area=" + getArea());
        System.out.println("Perimeter=" + getPerimeter());
    }
}