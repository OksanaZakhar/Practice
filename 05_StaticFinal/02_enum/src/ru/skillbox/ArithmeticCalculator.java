package ru.skillbox;

public class ArithmeticCalculator {
    public double numberA;
    public double numberB;
    public double resultAB;

    public ArithmeticCalculator(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public void calculate(Operation type) {
        switch (type) {
            case ADD:
                resultAB = numberA + numberB;
                break;
            case SUBTRACT:
                resultAB = numberA - numberB;
                break;
            case MULTIPLY:
                resultAB = numberA * numberB;
                break;
            default:
                break;
        }


    }

    public double getResultAB() {
        return resultAB;
    }
}
