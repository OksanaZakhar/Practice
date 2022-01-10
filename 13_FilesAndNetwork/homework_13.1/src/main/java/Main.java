import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке");
        String path = scanner.nextLine();
        try {
            if (new File(path).isDirectory()) {
                long size = FileUtils.calculateFolderSize(path);
                if (size <= 1024) {
                    System.out.println("Размер папки составляет " + (double) Math.round(size * 100) / 100 + "Б");
                } else if (size > 1024 && size <= Math.pow(1024, 2)) {
                    System.out.println("Размер папки составляет " + (double) Math.round((size / 1024) * 100) / 100 + "KБ");
                } else if (size > Math.pow(1024, 2) && size <= Math.pow(1024, 3)) {
                    System.out.println("Размер папки составляет " + (double) Math.round((size / Math.pow(1024, 2)) * 100) / 100 + "MБ");
                } else {
                    System.out.println("Размер папки составляет " + (double) Math.round(size / Math.pow(1024, 3) * 100) / 100 + "ГБ");
                }

            } else {
                System.out.println("Данный путь не верный");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
