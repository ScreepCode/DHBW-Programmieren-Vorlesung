package de.niklas.exercise.operators;
/**
 * <strong>Vorrang von Operatoren</strong><br>
 * Was gibt das folgende Programm Priority aus?
 *
 * @see "05_Operatoren_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Priority {
    public static void main(String[] args) {
        System.out.println("1: " + (5 / 2 * 2));                //Ausgabe: 4
        System.out.println("2: " + (9. / 2 * 5));               //Ausgabe: 22.5
        boolean a = true, b = false, c = false;
        System.out.println("3: " + (a && b || c));              //Ausgabe: false
        char ch = 'c';
        System.out.println("4: " + ('a' + 1 < ch));             //Ausgabe: true
        int i = 1, j = 2, k = 3;
        System.out.println("5: " + (-i - 5 * j >= k + 1));      //Ausgabe: false
        i = 1;
        if (a || (++i == 2)) {
            System.out.println("6: " + i);                      //Ausgabe: 1
        }
        i = 1;
        if (a | (++i == 2)) {
            System.out.println("7: " + i);                      //Ausgabe: 2
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
1: 4
2: 22.5
3: false
4: true
5: false
6: 1
7: 2
--------------------------------------
 */