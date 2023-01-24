package control;

import javax.sql.rowset.serial.SerialBlob;

public class AddUp {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int ergebnis = 0;
        while(true){
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            int zahl = scan.nextInt();
            if(zahl < 0){
                System.out.printf("Summe: %d", ergebnis);
                break;
            }
            else{
                ergebnis += zahl;
            }
        }

//        do{
//            System.out.print("Zahl eingeben (<0 für Abbruch): ");
//            int zahl = scan.nextInt();
//            if(zahl < 0){
//                System.out.printf("Summe: %d", ergebnis);
//                break;
//            }
//            else{
//                ergebnis += zahl;
//            }
//        }while (true);
    }

}
