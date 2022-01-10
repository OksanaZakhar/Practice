import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateJson {

    public String path;
    Document document = null;
    HashSet<String> hashSetLines = new HashSet<>();
    HashSet<String> hashSetStations = new HashSet<>();
    List<String> arrayList = new ArrayList<>();
    Elements elements = new Elements();
    Elements elements0 = new Elements();
    JSONObject obj = new JSONObject();
    String REGEX = "/metro/[a-z]+[-]*[1-2]*.html";
    List<HashMap> allList = new ArrayList<>();

    public CreateJson(String path) {
        this.path = path;

    }

    public void readHtml() {
        try {
            document = Jsoup.connect(path).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        elements = document.select("span[data-line]");// линии метро
        for (Element el : elements) {
            hashSetLines.add(el.text());
        }
        Elements elements2 = document.select("span[class=\"name\"]");// станции метро
        for (Element el : elements2) {
            hashSetStations.add(el.text());
        }
        Elements elements1 = document.select("span");
        for (Element el : elements1) {
            if (hashSetLines.contains(el.text()) || hashSetStations.contains(el.text())) {
                elements0.add(el);
            }
        }
    }

    public void writeJson() {
        createStation();
        createLines();
        createConnections();

        try (FileWriter file = new FileWriter("13_FilesAndNetwork/135_json/MSC.json")) {
            file.write(obj.toString());
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void createStation() {
        int key = 1;
        String keyStr = Integer.toString(key);

        LinkedHashMap<String, List<String>> hashMap = new LinkedHashMap<>();
        for (Element el : elements0) {
            if (hashSetLines.contains(el.text()) && arrayList.size() != 0) {
                hashMap.put(keyStr, arrayList);
                arrayList = new ArrayList<>();
                if (el.text().equals("Каховская линия")) {
                    keyStr = "11A";
                } else if (el.text().equals("МЦД-1")) {
                    keyStr = "D1";
                } else if (el.text().equals("МЦД-2")) {
                    keyStr = "D2";
                } else {
                    key = key + 1;
                    keyStr = Integer.toString(key);
                }
            } else if (hashSetStations.contains(el.text())) {
                arrayList.add(el.text());
            }
        }
        hashMap.put(keyStr, arrayList);
        obj.put("stations", hashMap);
    }

    public void createLines() {
        int key = 0;
        String keyStr;
        for (Element el : elements) {
            HashMap<String, String> allMap = new HashMap<>();
            if (el.text().equals("Каховская линия")) {
                keyStr = "11A";
            } else if (el.text().equals("МЦД-1")) {
                keyStr = "D1";
            } else if (el.text().equals("МЦД-2")) {
                keyStr = "D2";
            } else {
                key = key + 1;
                keyStr = Integer.toString(key);
            }
            allMap.put("number", keyStr);
            allMap.put("name", el.text());
            allList.add(allMap);
        }
        obj.put("lines", allList);
    }

    public void createConnections() {
        String REGEXLINE = "[1-9]*[0]*[. ]+[А-Я]*[а-я]+[ ]*[А-Я]*[а-я]+";
        String REGEXSTATION = "[D]?[1-9]+[0]*[A]?";

        Elements elementsURL = new Elements();
        elementsURL = document.select("a");// адреса линии метро
        List<String> listURL = new ArrayList<>();
        for (Element el : elementsURL) {
            if (el.attr("href").matches(REGEX) || el.attr("href").contains("-linija.html")
            ) {
                String s = "https://www.moscowmap.ru";
                s = s + el.attr("href");
                listURL.add(s);
            }
        }// данный блок выбирает и формирует ссылки на страницы станций!!!!!
        // но так как я заблокирована, то показую реализацию и рабочесть на одной из архивных ссылках
        Document documentLines = null;
        try {
            documentLines = Jsoup.connect("https://web.archive.org/web/20170702040839/https://www.moscowmap.ru/metro/sokolnicheskaya-linija.html").maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elementsConnections = new Elements();
        elementsConnections = documentLines.select("span");
        List<String> list = new ArrayList<>();
        for (Element el : elementsConnections) {
            if (el.text().matches(REGEXLINE) || el.text().matches(REGEXSTATION)) {
                list.add(el.text());
            }
            if (el.toString().contains("переход на станцию")) {
                list.add(el.toString());
            }
        }
        String lineMain = allList.get(0).get("number").toString();//это способ вытянуть номер станции, при наличии масива станций, формирование которого описано выше, но использовать который я не могу из-за блокировки
        String line = null;
        String stationMain = null;
        String station = null;
        int countConnection = 0;

        List<List> allList = new ArrayList<>();
        for (String l : list) {
            if (l.matches(REGEXLINE)) {
                stationMain = l.substring(l.indexOf(" "), l.length()).trim();
            }
            if (l.matches(REGEXSTATION)) {
                line = l;
            }
            if (l.contains("переход на станцию")) {
                station = l.substring(l.indexOf("«") + 1, l.lastIndexOf("»"));
                HashMap<String, String> lineMapMain = new HashMap<>();
                HashMap<String, String> lineMap = new HashMap<>();
                List<Map> allMap = new ArrayList<>();
                lineMapMain.put("line", lineMain);
                lineMapMain.put("station", stationMain);
                lineMap.put("line", line);
                lineMap.put("station", station);
                allMap.add(lineMapMain);
                allMap.add(lineMap);
                allList.add(allMap);
                countConnection = countConnection + 1;
            }
        }
        obj.put("connections", allList);
        System.out.println("Всего переходов - " + countConnection);
    }
}
