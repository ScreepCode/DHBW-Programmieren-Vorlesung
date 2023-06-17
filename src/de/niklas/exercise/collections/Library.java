package de.niklas.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <strong>Bücherei</strong><br>
 * Bücherdaten einer Bücherei mit Import/Export und Sortierungen
 *
 * @see "25_Datenstrukturen_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Library extends JFrame {
    JTextField author_field, title_field, year_field, publisher_field;
    JButton save, author, title, year, publisher;
    String filename = "FileExperiments/books.txt";
    List<Book> books;

    public Library() {
        books = new ArrayList<>();
        readBooks();
        generateGUI();
    }

    /**
     * Auslesen der Bücher aus der Datei und hinzufügen in die Arraylist
     */
    private void readBooks() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) { // BufferedReader um einzelne Zeilen lesen zu können
            while (bufferedReader.ready()) {
                String[] bookLine = bufferedReader.readLine().split(";");  // jede zeile wird ausgegeben
                books.add(new Book(bookLine[0], bookLine[1], bookLine[2], bookLine[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Speichern eines einzelnen! Buchs an die Datei
     * @param book neues Buch
     */
    private void writeBookToFile(Book book) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.println(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aktion um Bücher zu speichern
     */
    private void saveEntry() {
        Book book = new Book(title_field.getText(), author_field.getText(), year_field.getText(), publisher_field.getText());
        writeBookToFile(book);
        books.add(book);
    }

    /**
     * Gibt die Bücher in einem OptionPane aus
     * @param topic Übergebenes Thema für den Title
     */
    private void outputBooks(String topic) {
        StringBuilder out = new StringBuilder();
        for(Book book : books) {
            out.append(book.toString()).append(System.lineSeparator());
        }
        JOptionPane.showMessageDialog(null, out, String.format("Books ordered by: %s", topic), JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Aufbau der GUI
     */
    private void generateGUI() {
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(4, 2, 5, 5));
        north.add(new JLabel("Title"));
        title_field = new JTextField();
        north.add(title_field);
        north.add(new JLabel("Author"));
        author_field = new JTextField();
        north.add(author_field);
        north.add(new JLabel("Year"));
        year_field = new JTextField();
        north.add(year_field);
        north.add(new JLabel("Publisher"));
        publisher_field = new JTextField();
        north.add(publisher_field);
        this.add(north, BorderLayout.NORTH);

        save = new JButton("Save entry");
        save.addActionListener(e -> saveEntry());   // Lambda Action listener: Map vom Action listener auf eine eigene Funktion inkl. Übergabe des Aktion events
        this.add(save);

        JPanel south = new JPanel();
        south.add(new JLabel("sorted by: "));
        title = new JButton("Title");
        title.addActionListener(e -> {
            books.sort(new BookComparator("Title"));
            outputBooks("Title");
        });
        south.add(title);
        author = new JButton("Author");
        author.addActionListener(e -> {
            books.sort(new BookComparator("Author"));
            outputBooks("Author");
        });
        south.add(author);
        year = new JButton("Year");
        year.addActionListener(e -> {
            books.sort(new BookComparator("Year"));
            outputBooks("Year");
        });
        south.add(year);
        publisher = new JButton("Publisher");
        publisher.addActionListener(e -> {
            books.sort(new BookComparator("Publisher"));
            outputBooks("Publisher");
        });
        south.add(publisher);
        this.add(south, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Library();
    }
}

/**
 * Das Buch als eigenes Objekt
 */
class Book {
    String title, author, publisher;
    int year;

    public Book(String title, String author, String year, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = Integer.parseInt(year);
    }

    public String toString() {
        return String.format("%s;%s;%d;%s;", title, author, year, publisher);
    }
}

/**
 * Comparator für das Buch
 * Funktionsweise:
 * Ich übergebe einen Parameter, nach dem Sortiert wird
 * In der Compare Methode wird mittels SwitchCase (enhanced) der richtige Vergleich aufgerufen
 */
class BookComparator implements Comparator<Book> {
    String parameter;

    /**
     * Erzeugung des Comparators
     * @param parameter Parameter nach dem Sortiert werden soll
     */
    public BookComparator(String parameter) {
        this.parameter = parameter;
    }

    /**
     * Vergleichsmethode für Bücher
     * @param book1 Erstes Buch
     * @param book2 Zweites Buch, zu dem Verglichen wird
     * @return Rückgabe, ob Buch 1 größer Buch 2 ist
     */
    @Override
    public int compare(Book book1, Book book2) {
        return switch (parameter) {
            case "Title" -> book1.title.compareTo(book2.title);
            case "Author" -> book1.author.compareTo(book2.author);
            case "Year" -> book1.year - book2.year;
            case "Publisher" -> book1.publisher.compareTo(book2.publisher);
            default -> 0;
        };
    }

}