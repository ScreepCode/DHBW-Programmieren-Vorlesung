package de.niklas.exercise.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * <strong>Binärbaum</strong><br>
 * Implementation eines Binärbaums
 *
 * @see "25_Datenstrukturen_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class BinaryTree<T extends Comparable<T>> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    /**
     * Funktion um zu prüfen, ob der Baum gefüllt ist
     * @return Ob der Baum leer ist
     */
    public boolean isEmpty() {
        return this.value == null;
    }

    /**
     * Gebe den Wert des aktuell betrachten Wurzel zurück
     * @return Wert der angefragten Wurzel
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Gebe den linken Teilbaum zurück
     * @return linker Teilbaum
     */
    private BinaryTree<T> getLeft() {
        if (this.left == null) {
            this.left = new BinaryTree<>();
        }
        return this.left;
    }

    /**
     * Gebe den rechten Teilbaum zurück
     * @return rechter Teilbaum
     */
    private BinaryTree<T> getRight() {
        if (this.right == null) {
            this.right = new BinaryTree<>();
        }
        return this.right;
    }

    /**
     * Füge einen Wert in den Binärbaum hinzu, sodass seine Eigenschaften bestehen bleiben
     * @param newValue Einzufügender Wert
     * @return Ob das Einfügen funktioniert hat
     */
    public boolean add(T newValue) {
        if (this.isEmpty()) {
            this.value = newValue;
        }
        else if (this.value.compareTo(newValue) == 0) {
            return false;
        }
        else if (this.value.compareTo(newValue) > 0) {
            return this.getLeft().add(newValue);
        }
        else if (this.value.compareTo(newValue) < 0) {
            return this.getRight().add(newValue);
        }
        return true;
    }

    /**
     * Startmethode zum Baum traversieren
     * @return Liste mit sortierten Eintrögen des Baums
     */
    public List<T> traverse(){
        List<T> list = new LinkedList<>();
        this.traverseRecursive(list);
        return list;
    }

    /**
     * Rekursive Preorder Traversierung für Binärbaum
     */
    private void traverseRecursive(List<T> list) {
        if (!this.getLeft().isEmpty()) {
            this.left.traverseRecursive(list);
        }
        if (!this.isEmpty()) {
            list.add(this.getValue());
        }
        if (!this.getRight().isEmpty()) {
            this.right.traverseRecursive(list);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for(int i = 0; i < 10; i++){
            Integer randInt = new Random().nextInt(0, 20);
            System.out.printf("%d %b\n" , randInt, tree.add(randInt));
        }
        List<Integer> list = tree.traverse();
        System.out.println(list);
    }
}
