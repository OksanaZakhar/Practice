public class Cyrillic {
    private int firstUppercaseCirillic;
    private int lastUppercaseCirillic;
    private int firstLowercaseCirillic;
    private int lastLowercaseCirillic;
    private int uppercaseYo;
    private int lowercaseYo;


    public void findCirillic() {
        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            switch (c) {
                case 'А':
                    firstUppercaseCirillic = i;
                    break;
                case 'Я':
                    lastUppercaseCirillic = i;
                    break;
                case 'а':
                    firstLowercaseCirillic = i;
                    break;
                case 'я':
                    lastLowercaseCirillic = i;
                    break;
                case 'Ё':
                    uppercaseYo = i;
                    break;
                case 'ё':
                    lowercaseYo = i;
                    break;
                default:
                    break;

            }
        }


    }

    public void printCirillic() {
        String resCirillic = "";
        findCirillic();
        for (int i = firstUppercaseCirillic; i <= lastUppercaseCirillic; i++) {
            resCirillic = resCirillic + i + " - " + (char) i + "\n";
        }
        for (int i = firstLowercaseCirillic; i <= lastLowercaseCirillic; i++) {
            resCirillic = resCirillic + i + " - " + (char) i + "\n";
        }
        resCirillic = resCirillic + uppercaseYo + " - " + (char) uppercaseYo + "\n" + lowercaseYo + " - " + (char) lowercaseYo + "\n";

        System.out.println(resCirillic);
    }


}
