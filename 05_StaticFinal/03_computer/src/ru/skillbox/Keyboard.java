package ru.skillbox;

public class Keyboard {
    private final String typeKeyboard;
    private final boolean backlight;
    private final double weight;

    public Keyboard(String typeKeyboard, boolean backlight, double weight) {
        this.typeKeyboard = typeKeyboard;
        this.backlight = backlight;
        this.weight = weight;
    }

    public String getTypeKeyboard() {
        return typeKeyboard;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }
}
