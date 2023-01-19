package operators;

public class Easter {

    public static void main(String[] args) {
        System.out.println("Wir rechnen jetzt aus, wo Ostersonntag liegt");
        System.out.println("Von welchem Jahr möchtest du es ausrechnen?");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int jahr = scan.nextInt();

        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int ostern = (22 + d + e);


        String monat = (ostern <= 31) ? "März" : "April";
        ostern = (ostern <= 31) ? ostern : ostern-31;
        System.out.printf("Im Jahr %d liegt Ostern am %d. %s.", jahr, ostern, monat);
    }
}
