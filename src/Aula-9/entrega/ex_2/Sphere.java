public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(int radius) {
        this.radius = radius;
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4/3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public void show() {
        System.out.println("Sphere: radius=" + radius);
        System.out.println("Volume=" + getVolume());
        System.out.println("Surface Area=" + getSurfaceArea());
    }
}
