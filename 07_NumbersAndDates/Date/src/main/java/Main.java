import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 21;
        int month = 9;
        int year = 1982;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        System.out.println("Мой ДР: " + birthday);
        System.out.println("Сегодня: " + today);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EE").withLocale(Locale.ENGLISH);

        // Способ 1
        int dateUntil = (int) birthday.until(today, ChronoUnit.YEARS);
        String text = "";

        for (int i = 0; i <= dateUntil; i++) {
            text = text + i + " - " + formatter.format(birthday.plusYears(i)) + System.lineSeparator();
        }
        if (birthday.isAfter(today)) {
            text = "";
        }


        /*/ Способ 2
        String text1 = "";
        int k = 0;
        while (birthday.isBefore(today)){
            text1 = text1 +  k++ + " - " + formatter.format(birthday) + System.lineSeparator();
            birthday = (birthday.plusYears(1));
        }

        System.out.println(text1);*/


        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        return text;
    }
}
