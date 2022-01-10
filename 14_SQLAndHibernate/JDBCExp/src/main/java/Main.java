import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "##########";


        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(subscription_date),  course_name, MAX(MONTH(subscription_date)) as maxMonth, MIN(MONTH(subscription_date)) as minMonth, subscription_date " +
                    "FROM PurchaseList " +
                    "GROUP BY course_name " +
                    "ORDER BY subscription_date ");
            while (resultSet.next()) {
                String min = resultSet.getString("minMonth");
                String max = resultSet.getString("maxMonth");
                double midle = (double) Math.round((resultSet.getInt(1) / (Double.parseDouble(max) - Double.parseDouble(min) + 1)) * 100) / 100;

                System.out.println(resultSet.getString("course_name"));
                System.out.println("общее количество " + resultSet.getInt(1) + "   " +
                        "начальный месяц " + min + "   " +
                        "последний месяц " + max + "   " +
                        "среднее количество покупок в месяц " + midle);

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
