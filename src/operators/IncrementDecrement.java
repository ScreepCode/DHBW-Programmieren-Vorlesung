package operators;
/**
 * <h1>Inkrement und Dekrement</h1>
 * Was gibt das folgende Programm IncrementDecrement aus?
 *
 * @see "05_Operatoren_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class IncrementDecrement {

    public static void main(String[] args) {
        int i=0;
        int j=0;
        j = ++i;
        int k = j++ + ++i;
        System.out.println("k: " + k);          // Ausgabe: k=3
        System.out.println("*: " + j++ + ++i);  // Ausgabe: *: 23
        System.out.println(j++ + ++i);          // Ausgabe: 7
        int m = j++ * ++i;
        System.out.println("m: " + m);          // Ausgabe: m: 20
        int n = --j * --i;
        System.out.println("n: " + n);          // Ausgabe: n: 16
        System.out.println("i: " + i);          // Ausgabe: i: 4
        System.out.println("j: " + j);          // Ausgabe: j: 4
    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
k: 3
*: 23
7
m: 20
n: 16
i: 4
j: 4
--------------------------------------
 */
