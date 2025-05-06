import java.util.Scanner;

public class TestShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada Circle
        System.out.print("Enter radius (int): ");
        int rInt = scanner.nextInt();
        Circle cInt = new Circle(rInt);
        cInt.show();

        System.out.print("Enter radius (double): ");
        double rDouble = scanner.nextDouble();
        Circle cDouble = new Circle(rDouble);
        cDouble.show();

        // Entrada Square
        System.out.print("Enter side of square (int): ");
        int sInt = scanner.nextInt();
        Square sqInt = new Square(sInt);
        sqInt.show();

        System.out.print("Enter side of square (double): ");
        double sDouble = scanner.nextDouble();
        Square sqDouble = new Square(sDouble);
        sqDouble.show();

        // Entrada Triangle
        System.out.print("Enter base of triangle (int): ");
        int baseInt = scanner.nextInt();
        System.out.print("Enter height of triangle (int): ");
        int heightInt = scanner.nextInt();
        Triangle tInt = new Triangle(baseInt, heightInt);
        tInt.show();

        System.out.print("Enter base of triangle (double): ");
        double baseDouble = scanner.nextDouble();
        System.out.print("Enter height of triangle (double): ");
        double heightDouble = scanner.nextDouble();
        Triangle tDouble = new Triangle(baseDouble, heightDouble);
        tDouble.show();

        // Entrada Sphere
        System.out.print("Enter radius of sphere (int): ");
        int rsInt = scanner.nextInt();
        Sphere sIntObj = new Sphere(rsInt);
        sIntObj.show();

        System.out.print("Enter radius of sphere (double): ");
        double rsDouble = scanner.nextDouble();
        Sphere sDoubleObj = new Sphere(rsDouble);
        sDoubleObj.show();

        // Entrada Cube
        System.out.print("Enter side of cube (int): ");
        int scInt = scanner.nextInt();
        Cube cIntObj = new Cube(scInt);
        cIntObj.show();

        System.out.print("Enter side of cube (double): ");
        double scDouble = scanner.nextDouble();
        Cube cDoubleObj = new Cube(scDouble);
        cDoubleObj.show();

        // Entrada Tetrahedron
        System.out.print("Enter edge of tetrahedron (int): ");
        int teInt = scanner.nextInt();
        Tetrahedron tIntObj = new Tetrahedron(teInt);
        tIntObj.show();

        System.out.print("Enter edge of tetrahedron (double): ");
        double teDouble = scanner.nextDouble();
        Tetrahedron tDoubleObj = new Tetrahedron(teDouble);
        tDoubleObj.show();

        scanner.close();
    }
}
