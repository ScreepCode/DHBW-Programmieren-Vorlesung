package de.niklas.exercise.classes.periodic;

/**
 * <strong>Periodensystem</strong><br>
 * Implementation eines Periodensystems mit Fokus auf Metalle
 *
 * @see "13_Vererbung_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class PeriodicTable {

    private Element[] elements = new Element[119];

    /**
     * Fügt ein Element dem Periodensystem hinzu, wenn es noch nicht vorhanden ist
     * @param e Element
     */
    public void addElement(Element e) {
        if (!hasElement(e.getOrdinal())){   // Wenn hasElement false zurückgibt (Vorsicht: mit dem ! negiert), dann darf das Element hinzugefügt werden
            elements[e.getOrdinal()] = e;
        }
    }

    /**
     * Überprüft, ob das Element mit der eingegebenen Ordnungszahl im Periodensystem drin ist
     * @param o Ordnungszahl
     * @return Vorhanden ja/nein
     */
    public boolean hasElement(int o) {
        return elements[o] != null;         // Wenn in dem Array ein Eintrag vorhanden ist
    }                                       //  Bei Objekten wird standard maßig null eintragen als Startwert

    /**
     * Gibt das Element mit der eingegebenen Ordnungszahl zurück
     * @param o Ordnungszahl
     * @return Element, wenn vorhanden oder null
     */
    public Element getElement(int o) {      // Gebe Element an Stelle der Ordnungszahl zurück
        return elements[o];
    }

    /**
     * Gibt einen Array mit allen Metallen zurück, die im Periodensystem sind
     * @return
     */
    public Element[] getMetals() {
        int countMetals = 0;
        for (Element element : elements){                       // Diese Schleife zählt erstmal, wie viele Metalle es gibt, damit wir das Array erzeugen können.
            if (element != null && element instanceof Metal){
                countMetals++;
            }
        }
        Element[] result = new Element[countMetals];
        int pos = 0;
        for (Element element : elements){
            if (element != null && element instanceof Metal){
                result[pos++] = element;                        // Hier werden dann die Metalle aufs Array geschrieben
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PeriodicTable table = new PeriodicTable();
        table.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
        table.addElement(new Element("Helium", "He", 2, 'K', 3, true));
        table.addElement(new Metal("Natrium", "Na", 11, 'M', 1, true, false, 21e6));
        table.addElement(new Metal("Eisen", "Fe", 26, 'N', 1, false, false, 10.02e6));
        table.addElement(new Metal("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
        table.addElement(new Element("Brom", "Br", 35, 'K', 2, true));
        table.addElement(new Metal("Tellur", "Te", 52, 'O', 1, true, true, 0.005));
        table.addElement(new Metal("Gold", "Au", 79, 'P', 1, false, false, 44e6));

        System.out.println("Metalle:");
        for (Element element : table.getMetals()){
            System.out.println(element);
        }
        System.out.println();
        System.out.println("Gold:");
        System.out.println(table.getElement(79));

    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Metalle:
Natrium (Na, 11) Schale: M, fest, Gruppe: Hauptgruppe, σ: 2.1E7
Eisen (Fe, 26) Schale: N, fest, Gruppe: Nebengruppe, σ: 1.002E7
Germanium (Ge, 32) Schale: N, fest, Gruppe: Nebengruppe, Halbleiter, σ: 1.45
Tellur (Te, 52) Schale: O, fest, Gruppe: Hauptgruppe, Halbleiter, σ: 0.005
Gold (Au, 79) Schale: P, fest, Gruppe: Nebengruppe, σ: 4.4E7

Gold:
Gold (Au, 79) Schale: P, fest, Gruppe: Nebengruppe, σ: 4.4E7
--------------------------------------
 */

