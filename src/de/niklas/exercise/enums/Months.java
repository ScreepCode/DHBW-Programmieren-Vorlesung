package de.niklas.exercise.enums;

import java.util.Calendar;

/**
 * <strong>Monate</strong><br>
 * Die Monate inkl. Tageszahl und alter Namen als Enum
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Months{
    public enum Month {
        JANUAR("Januar", 31, "Hartung, Eismond"),
        FEBRUAR("Februar", 28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
        MAERZ("März", 31, "Lenzing, Lenzmond"),
        APRIL("April", 30, "Launing, Ostermond"),
        MAI("Mai", 31, "Winnemond*, Blumenmond"),
        JUNI("Juni", 30, "Brachet, Brachmond"),
        JULI("Juli", 31, "Heuert, Heumond"),
        AUGUST("August", 31, "Ernting, Erntemond, Bisemond"),
        SEPTEMBER("September", 30, "Scheiding, Herbstmond"),
        OKTOBER("Oktober", 31, "Gilbhart, Gilbhard, Weinmond"),
        NOVEMBER("November", 30, "Nebelung, Windmond, Wintermond"),
        DEZEMBER("Dezember", 31, "Julmond, Heilmond, Christmond, Dustermond");


        public final String name;
        public final int days;
        public final String oldNames;

        /**
         * Konstruktor für das Enum
         * @param name Monatsname
         * @param days Tage des Monats
         * @param oldNames Alte Namen
         */
        Month(String name, int days, String oldNames) {
            this.name = name;
            this.days = days;
            this.oldNames = oldNames;
        }

        public String toString() {
            return String.format("Der %s hat %d Tage und hieß früher '%s'", name, days, oldNames);
        }
    }

    public static void main(String[] args) {
        for (Month m : Month.values()) {
            System.out.println(m);
        }
        int aktMonth = Calendar.getInstance().get(Calendar.MONTH);
        System.out.printf("Aktueller Monat: %s", Month.values()[aktMonth]);
    }

}
