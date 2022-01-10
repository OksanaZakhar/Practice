import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            String regex = "[а-яА-Я\\-]+\\s+[а-яА-Я\\-]+\\s+[а-яА-Я\\-]+";
            String[] words = input.split("\\s+");
            if (!input.matches(regex) || words.length > 3) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            System.out.println("Фамилия: " + words[0] + System.lineSeparator() +
                    "Имя: " + words[1] + System.lineSeparator() +
                    "Отчество: " + words[2]);


            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
        }
    }

}