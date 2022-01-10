import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            boolean isCirillic = true;
            for (int i = 1; i < input.length(); i++) {
                if (!(Character.UnicodeBlock.of(input.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || input.charAt(i) == ' ' || input.charAt(i) == '-')) {
                    isCirillic = false;
                }
            }
            int start = input.indexOf(' ');
            int end = input.lastIndexOf(' ');

            if (start == end || start < 0 || !isCirillic || input.substring(start + 1, end).lastIndexOf(' ') > 0) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            System.out.println("Фамилия: " + input.substring(0, start) + System.lineSeparator() +
                    "Имя: " + input.substring(start + 1, end) + System.lineSeparator() +
                    "Отчество: " + input.substring(end + 1, input.length()));


            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
        }
    }

}