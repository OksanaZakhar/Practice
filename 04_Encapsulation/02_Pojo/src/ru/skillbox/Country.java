package ru.skillbox;

public class Country {
    private String nameOfCountry;
    private int population;
    private int areaSqKm;
    private String capital;
    private boolean presenceAccessSea;

    public Country(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public int getPopulation() {
        return population;
    }

    public int getAreaSqKm() {
        return areaSqKm;
    }

    public String getCapital() {
        return capital;
    }

    public boolean isPresenceAccessSea() {
        return presenceAccessSea;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAreaSqKm(int areaSqKm) {
        this.areaSqKm = areaSqKm;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPresenceAccessSea(boolean presenceAccessSea) {
        this.presenceAccessSea = presenceAccessSea;
    }
}
