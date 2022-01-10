import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        long sumSizesFiles = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                for (File file1 : file.listFiles()) {
                    if (file1.isDirectory()) {
                        for (File file2 : file1.listFiles()) {
                            sumSizesFiles = sumSizesFiles + file2.length();
                        }
                    } else {
                        sumSizesFiles = sumSizesFiles + file1.length();
                    }
                }
            } else {
                sumSizesFiles = sumSizesFiles + file.length();
            }
        }
        return sumSizesFiles;
    }
}
