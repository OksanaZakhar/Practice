public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int indexPart1 = text.indexOf(", ");
        String part1 = text.substring(0, indexPart1);
        int indexPart3 = text.lastIndexOf(", ");
        String part3 = text.substring(indexPart3 + 2, text.length());
        String part2 = text.substring(indexPart1 + 2, indexPart3);
        String textRubl = " рубл";
        part1 = part1.substring(0, part1.indexOf(textRubl));
        part2 = part2.substring(0, part2.indexOf(textRubl));
        part3 = part3.substring(0, part3.indexOf(textRubl));
        part1 = part1.substring(part1.lastIndexOf(" "), part1.length()).trim();
        part2 = part2.substring(part2.lastIndexOf(" "), part2.length()).trim();
        part3 = part3.substring(part3.lastIndexOf(" "), part3.length()).trim();
        int sum = Integer.parseInt(part1) + Integer.parseInt(part2) + Integer.parseInt(part3);
        System.out.println(sum);


        //TODO: напишите ваш код, результат вывести в консоль
    }

}