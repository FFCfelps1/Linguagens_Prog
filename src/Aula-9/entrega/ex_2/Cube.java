public class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(int side) {
        this.side = side;
    }

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 6 * side * side;
    }

    @Override
    public void show() {
        System.out.println("Cube: side=" + side);
        System.out.println("Volume=" + getVolume());
        System.out.println("Surface Area=" + getSurfaceArea());
    }
}
