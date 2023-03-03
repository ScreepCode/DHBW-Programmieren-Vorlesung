package de.niklas.classes;
/**
 * <strong>Bankkonto</strong><br>
 * Schreiben eines Bankkontos mit Attributen Kontonummer, Besitzername, Kontostand und Limit
 *
 * @see "09_Klassen_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Account {
    private int accountNumber;
    private String accountOwner;
    private int accountHeight;
    private int accountLimit;

    /**
     * Erstellen eines Kontos
     *
     * @param accountNumber Kontonummer
     * @param accountOwner Kontoinhaber
     * @param accountHeight Kontostand
     * @param accountLimit Limit
     */
    public Account(int accountNumber, String accountOwner, int accountHeight, int accountLimit) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.accountHeight = accountHeight;
        this.accountLimit = accountLimit;
    }

    /**
     * Rückgabe des Kontowerts
     * @return Kontowert
     */
    public int getAccountHeight() {
        return this.accountHeight;
    }

    /**
     * Ausgabe der Kontoinformationen als String
     * @return Kontoinformationen
     */
    @Override
    public String toString() {
        return  "Konto Nr. " + this.accountNumber + " (" + this.accountOwner + "), " +
                "Stand: " + this.accountHeight + " ct " +
                "Limit " + this.accountLimit + " ct";
    }

    /**
     * Erhöhen des Kontostands um den einzuzahlenden Wertes
     * @param amount Einzahlungssumme
     */
    public void processDeposit(int amount){
        this.accountHeight += amount;
    }

    /**
     * Bezahlen einer Summe, solange das Konto inklusive Limit dieses auch zulässt.
     * @param amount Zahlungssumme
     */
    public void processPayment(int amount){
        if(this.accountHeight - amount >= (this.accountLimit*-1)){
            this.accountHeight -= amount;
        }
        else{
            System.out.println("\u001B[31mDeckung nicht ausreichend!\u001B[0m"); // Hier wird die Farbe des Roten String direkt in das Ausgeben hinzugefügt.
        }                                                                        //     Die Farbinformation wird mit dem Unicode "\u0001B" begonnen und beendet. Die nachstehenden Werte entscheiden die Farbe
    }

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Konto Nr. 4711 (Donald Duck), Stand: 500 ct Limit 1000 ct
Konto Nr. 4711 (Donald Duck), Stand: 700 ct Limit 1000 ct
Konto Nr. 4711 (Donald Duck), Stand: 300 ct Limit 1000 ct
Deckung nicht ausreichend!
Konto Nr. 4711 (Donald Duck), Stand: 300 ct Limit 1000 ct
--------------------------------------
 */
