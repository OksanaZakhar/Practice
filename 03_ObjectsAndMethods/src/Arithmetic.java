public class Arithmetic {

    private int numberA;
    private int numberB;
    private static String rezultAB = "";

    public Arithmetic(int numbA, int numbB) {
        numberA = numbA;
        numberB = numbB;
        this.numberManipulation();
    }

    public void numberManipulation() {
        rezultAB = rezultAB + "Числа " + numberA + " и " + numberB + ": Cумма = " + numberSum() + ", Произведение = " + numberMulti() + ", Наибольшее = " + numberMax() + ", Наименьшее = " + numberMin();
    }

    public int numberSum() {
        return numberA + numberB;
    }

    public int numberMulti() {
        return numberA * numberB;
    }

    public int numberMax() {
        int maxAB = numberB;
        if (numberA > numberB) {
            maxAB = numberA;
        }
        return maxAB;
    }

    public int numberMin() {
        int minAB = numberA;
        if (numberA > numberB) {
            minAB = numberB;
        }
        return minAB;
    }


    public static void printArithmetic() {
        System.out.println(rezultAB);
    }

}
