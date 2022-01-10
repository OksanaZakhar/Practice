package main.java;

public class GeometryCalculator {

    private static double radiusCircle = 0.0;
    private static double radiusSphere = 0.0;


    public GeometryCalculator() {
    }

    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        radiusCircle = Math.abs(radius);
        return Math.PI * Math.pow(radiusCircle, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        radiusSphere = Math.abs(radius);
        return 4.0 / 3.0 * Math.PI * Math.pow(radiusSphere, 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);

    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0

    public static double getTriangleSquare(double a, double b, double c) {

        if (!isTrianglePossible(a, b, c)) {
            System.out.println("Треугольник невозможно построить, проверьте стороны");
            return 0;
        }
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


}

