package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(2, 2, 2);
        CourierService courierService = new CourierService(dimensions.getDimensionsParcel(), 25, "St. Tree 25", true, "ab1234567", false);
        System.out.println(courierService);

        Dimensions dimensions2 = new Dimensions(1, 1, 1);
        CourierService courierService2 = new CourierService(dimensions2.getDimensionsParcel(), 10, "St. Tree 14", true, "ab142724", false);
        System.out.println(courierService2);

        Dimensions dimensions3 = dimensions.setWidth(3);
        CourierService courierService3 = courierService.setDimensionsParcel(dimensions3.getDimensionsParcel());
        System.out.println(courierService3);


    }
}
