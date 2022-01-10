import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate birthdayJava = LocalDate.of(1995, 5, 25);
        getPeriodFromBirthday(birthdayJava);

    }

    private static String getPeriodFromBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();

        System.out.println(birthday.until(today, ChronoUnit.YEARS) + " years, " +
                (birthday.until(today, ChronoUnit.MONTHS) - birthday.until(today, ChronoUnit.YEARS) * 12) + " months, " +
                (int) (birthday.until(today, ChronoUnit.DAYS) - (birthday.until(today, ChronoUnit.MONTHS) * (365.2425 / 12.0))) + " days");
        //25 years, 4 months, 6 days

        return "";
    }

}
