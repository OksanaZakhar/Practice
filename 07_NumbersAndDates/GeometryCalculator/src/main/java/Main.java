import main.java.GeometryCalculator;

public class Main {
    public static void main(String[] args) {

        GeometryCalculator geometryCalculator = new GeometryCalculator();

        System.out.println("Площадь круга - " + geometryCalculator.getCircleSquare(10));
        System.out.println("Объем шара - " + geometryCalculator.getSphereVolume(-1));
        System.out.println("Площадь треугольника - " + geometryCalculator.getTriangleSquare(3, 4, 5));


    }
}
