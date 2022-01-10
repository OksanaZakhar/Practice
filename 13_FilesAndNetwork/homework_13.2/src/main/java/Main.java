import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке, которую необходимо скопировать");
        String pathCopy = scanner.nextLine();
        System.out.println("Введите путь к папке, куда необходимо скопировать");
        String pathТоCopy = scanner.nextLine();
        try {
            if (new File(pathCopy).isDirectory() && new File(pathТоCopy).isDirectory()) {
                FileUtils.copyFolder(pathCopy, pathТоCopy);

            } else {
                System.out.println("Данный путь не верный");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
