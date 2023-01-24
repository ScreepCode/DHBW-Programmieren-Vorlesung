package control;

public class Babylon {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        double zahl = scan.nextInt();
        double x1 = 0;
        double x2 = 1;
        while (Math.abs(x2-x1) > 0.000001){
            x1 = x2;
            x2 = (x1 + (zahl / x1)) /2;
            System.out.println(x2);
        };

        System.out.printf("Die Wurzel aus %.0f ist %.2f", zahl, x2);
    }
}
