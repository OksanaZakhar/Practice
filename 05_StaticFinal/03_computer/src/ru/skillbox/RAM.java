package ru.skillbox;

public class RAM {
    private final String typeRAM;
    private final int volume;
    private final double weight;

    public RAM(String typeRAM, int volume, double weight) {
        this.typeRAM = typeRAM;
        this.volume = volume;
        this.weight = weight;
    }

    public String getTypeRAM() {
        return typeRAM;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
