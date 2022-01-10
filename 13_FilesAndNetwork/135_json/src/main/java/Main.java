public class Main {
    //public static String PATH_HTML = "https://www.moscowmap.ru/metro.html#lines";
    public static String PATH_HTML = "https://go.skillbox.ru/media/files/3205e9a7-622e-42f1-ae73-7634c7bfaeb5/Karta_metro_Moskvy_so_stantsiiami_MTsK_i_MTsD_2020_UYmgUul.html";
    public static String PATH_JSON = "13_FilesAndNetwork/135_json/MSC.json";


    public static void main(String[] args) {
        CreateJson createJson = new CreateJson(PATH_HTML);
        createJson.readHtml();
        createJson.writeJson();

        ReadJson readJson = new ReadJson(PATH_JSON);


    }
}
