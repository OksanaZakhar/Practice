public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 3, 0.75);
        basket.add("Coffee", 120, 1, 0.5);

        basket.print("Milk and Coffee");

        System.out.println("Сумма корзины " + basket.getTotalPrice());
        System.out.println("Вес корзины " + basket.getTotalWeight());
        System.out.println();

        Basket basket2 = new Basket();
        basket2.add("Aple", 20, 5, 1);
        basket2.add("Candy", 200, 2, 0.25);

        basket2.print("Aple and Candy");

        System.out.println("Сумма корзины " + basket2.getTotalPrice());
        System.out.println("Вес корзины " + basket2.getTotalWeight());
        System.out.println();


        System.out.println("Итого количество единиц: " + Basket.getTotalBasketCount());
        System.out.println("Общая сумма: " + Basket.getTotalBasketPrice());
        System.out.println("Средняя цена за единицу: " + Basket.averagePrice());
        System.out.println("Средняя сумма корзины: " + Basket.averagePriceInBasket());


    }
}
