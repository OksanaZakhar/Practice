import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String puth = "13_FilesAndNetwork/134/imeg";
    public static String url = "https://lapkins.ru/dog/pudel";
    public static List<String> link = new ArrayList<>();

    public static void main(String[] args) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements element = document.getElementsByTag("img");

        element.forEach(element1 -> {
            link.add(element1.attr("src"));
        });

        for (String l : link) {
            String strUrl = "https://lapkins.ru" + l;
            try {
                URL urlBuf = new URL(strUrl);
                BufferedImage img = ImageIO.read(urlBuf);
                String puthBuf = puth.concat(l.substring(l.lastIndexOf("/"), l.length()));
                ImageIO.write(img, "jpg", new File(puthBuf));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(l);
        }

    }
}

