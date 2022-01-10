package ru.skillbox;

public class Coffee {
    private String coffeeBrand;
    private String producingCountry;
    private String typeOfCoffee;
    private int averagePricePerKg;
    private double worldSalesUSD;

    public Coffee(String coffeeBrand, double worldSalesUSD) {
        this.coffeeBrand = coffeeBrand;
        this.worldSalesUSD = worldSalesUSD;
    }

    public String getCoffeeBrand() {
        return coffeeBrand;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public int getAveragePricePerKg() {
        return averagePricePerKg;
    }

    public double getWorldSalesUSD() {
        return worldSalesUSD;
    }

    public void setCoffeeBrand(String coffeeBrand) {
        this.coffeeBrand = coffeeBrand;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public void setTypeOfCoffee(String typeOfCoffee) {
        this.typeOfCoffee = typeOfCoffee;
    }

    public void setAveragePricePerKg(int averagePricePerKg) {
        this.averagePricePerKg = averagePricePerKg;
    }

    public void setWorldSalesUSD(double worldSalesUSD) {
        this.worldSalesUSD = worldSalesUSD;
    }
}
