import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String regex = "[^0-9]";
            input = input.replaceAll(regex, "");
            if (input.charAt(0) == '8') {
                input = input.substring(1, input.length());
            }
            if (input.charAt(0) == '9') {
                input = 7 + input;
            }
            if (input.charAt(0) != '7' || input.length() != 11) {
                System.out.println("Неверный формат номера");
                break;
            }
            System.out.println(input);

            //TODO:напишите ваш код тут, результат вывести в консоль.
        }
    }

}
