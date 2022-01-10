public class Printer {

    private String stringQueue = "";
    private String stringQueueText = "";
    private int numberOfPages = 0;
    private int totalPagesPrinted;

    public void append(String docText, String nameText, int numOfPages) {
        stringQueue = stringQueue + "\n" + nameText;
        stringQueueText = stringQueueText + "\n" + docText;
        numberOfPages = numberOfPages + numOfPages;
    }

    public void append(String docText, String nameText) {
        append(docText, nameText, 1);
    }

    public void append(String docText) {
        append(docText, "Noname", 1);
    }

    public int getPendingPagesCount() {
        return numberOfPages;

    }

    public void clear() {
        stringQueue = "";
        stringQueueText = "";
        numberOfPages = 0;
    }

    public void print() {
        System.out.println("Добавлены файлы на печать - " + stringQueue + "\n");
        System.out.println("Печатаеться текст" + stringQueueText + "\n");
        System.out.println("Количество страниц распечатано - " + getPendingPagesCount());
        totalPagesPrinted = totalPagesPrinted + getPendingPagesCount();
        clear();
        System.out.println("Количество страниц ВСЕГО распечатано - " + totalPagesPrinted);
    }
}
