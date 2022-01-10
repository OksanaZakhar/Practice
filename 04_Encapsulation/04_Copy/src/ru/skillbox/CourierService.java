package ru.skillbox;

public class CourierService {
    private final double dimensionsParcel;
    private final double weightParcel;
    private final String deliveryAddress;
    private final boolean possibleToFlip;
    private final String registrationNumber;
    private final boolean fragileCargo;

    public CourierService(double dimensionsParcel, double weightParcel, String deliveryAddress, boolean possibleToFlip, String registrationNumber, boolean fragileCargo) {
        this.dimensionsParcel = dimensionsParcel;
        this.weightParcel = weightParcel;
        this.deliveryAddress = deliveryAddress;
        this.possibleToFlip = possibleToFlip;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }

    public double getDimensionsParcel() {
        return dimensionsParcel;
    }

    public double getWeightParcel() {
        return weightParcel;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isPossibleToFlip() {
        return possibleToFlip;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragileCargo() {
        return fragileCargo;
    }

    public CourierService setDimensionsParcel(double dimensionsParcel) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public CourierService setWeightParcel(double weightParcel) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public CourierService setDeliveryAddress(String deliveryAddress) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public CourierService setPossibleToFlip(boolean possibleToFlip) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public CourierService setRegistrationNumber(String registrationNumber) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public CourierService setFragileCargo(boolean fragileCargo) {
        return new CourierService(dimensionsParcel, weightParcel, deliveryAddress, possibleToFlip, registrationNumber, fragileCargo);
    }

    public String toString() {
        return "ПОСЫЛКА" + "\n" +
                "Объем: " + dimensionsParcel + "\n" +
                "Вес: " + weightParcel + "\n" +
                "Адрес: " + deliveryAddress + "\n" +
                "Возможность переворачивать: " + possibleToFlip + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Хрупкрость: " + fragileCargo;
    }

}
