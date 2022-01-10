import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculateSalarySum("50 - A, 100 - B, 20 - C"));

    }

    public static int calculateSalarySum(String text) {
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            sum = sum + Integer.parseInt(text.substring(start, end));
        }
        //TODO: реализуйте метод
        return sum;
    }

}