public class test {

    public static void main(String[] args) {

        String str = String.format("%s : %s [%d]", "Hallo", "Welt", 42);

        // Du könntest machen:
        int indexKlammerAuf = str.lastIndexOf('[');
        int indexKlammerZu = str.lastIndexOf(']');
        if (indexKlammerAuf != -1 && indexKlammerZu != 1) { // -1 kommt zurück, wenn es das Zeichen nicht gibt
            String stringTeil = str.substring(0, indexKlammerAuf - 1);
            int zahl = Integer.parseInt(str.substring(indexKlammerAuf + 1, indexKlammerZu));
            System.out.println(stringTeil);
            System.out.println(zahl);

            System.out.printf("%s [%d]%n", stringTeil, zahl+1);
        }

    }
}
