import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static String url = "https://skillbox.ru/";
    public static Set<String> visited;
    public static File file;
    public static List<String> listForFile;
    public static Set<String> allUrls;
    public static String level = "";

    public static void main(String[] args) {
        listForFile = new ArrayList<>();
        visited = new HashSet<>();
        allUrls = new HashSet<>();
        listForFile.add(url);

        new ForkJoinPool().invoke(new RecursiveLinkFinder(LinkFinder.findPage(url)));

        file = new File("Links.txt");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (String s : listForFile) {
                writer.write(s + System.lineSeparator());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
