package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(20, 1.5);
        arithmeticCalculator.calculate(Operation.ADD);
        System.out.println(arithmeticCalculator.getResultAB());
        arithmeticCalculator.calculate(Operation.SUBTRACT);
        System.out.println(arithmeticCalculator.getResultAB());
        arithmeticCalculator.calculate(Operation.MULTIPLY);
        System.out.println(arithmeticCalculator.getResultAB());

    }
}
