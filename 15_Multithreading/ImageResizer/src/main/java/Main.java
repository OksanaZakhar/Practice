import java.io.File;

public class Main {

    private static int newWidth = 300;
    private static String srcFolder = "/users/user/Desktop/src";
    private static String dstFolder = "/users/user/Desktop/dst";

    public static void main(String[] args) {

        int processorCores = Runtime.getRuntime().availableProcessors();// Количество ядер процессора
        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        int part = files.length / processorCores;
        int iter = 0;
        for (int i = 0; i < processorCores - 1; i++) {
            File[] files1 = new File[part];
            System.arraycopy(files, part * i, files1, 0, files1.length);
            ImageResizer resizer1 = new ImageResizer(files1, newWidth, dstFolder, start);
            new Thread(resizer1).start();
            File[] file = new File[part];
            iter++;
        }

        File[] files2 = new File[files.length - part * iter];
        System.arraycopy(files, part * iter, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(files2, newWidth, dstFolder, start);
        new Thread(resizer2).start();

    }

}