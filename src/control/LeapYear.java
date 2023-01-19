package control;

public class LeapYear {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        int jahr = scan.nextInt();

        if((jahr%4 == 0) && (jahr%100 != 0) || jahr % 400 == 0){
            System.out.printf("%d ist ein Schaltjahr", jahr);
        }
        else {
            System.out.printf("%d ist kein Schaltjahr", jahr);
        }
    }
}
