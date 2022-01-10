import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkFinder {

    private static String domen = "https://skillbox.ru/";

    public static List<String> findPage(String mainUrl) {
        List<String> listURL = new ArrayList<>();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Main.visited.contains(mainUrl)) {
            synchronized (Main.visited) {
                Main.visited.add(mainUrl);
                Main.allUrls.add(mainUrl);
                Main.level = Main.level + "  ";
            }
            try {
                Document document = null;
                try {
                    document = Jsoup.connect(mainUrl).maxBodySize(0).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements elements = document.select("a[href]");
                for (Element el : elements) {
                    String url = "";
                    if (el.attr("href").startsWith("/")) {
                        url = domen + el.attr("href").substring(1);
                    } else {
                        url = el.attr("abs:href");
                    }
                    if (url.startsWith(domen) && !url.endsWith(".pdf") && !Main.visited.contains(url)) {
                        listURL.add(url);

                        if (!Main.allUrls.contains(url)) {
                            Main.listForFile.add(Main.level + url);

                        }
                        Main.allUrls.add(url);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listURL;
    }

}
