public class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    public Tetrahedron(int edge) {
        this.edge = edge;
    }

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getVolume() {
        return (Math.pow(edge, 3)) / (6 * Math.sqrt(2));
    }

    @Override
    public double getSurfaceArea() {
        return Math.sqrt(3) * edge * edge;
    }

    @Override
    public void show() {
        System.out.println("Tetrahedron: edge=" + edge);
        System.out.println("Volume=" + getVolume());
        System.out.println("Surface Area=" + getSurfaceArea());
    }
}
