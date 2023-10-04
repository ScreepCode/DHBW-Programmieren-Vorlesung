# Live Templates
> **Anleitung**: IntelliJ → Settings → Live Templates → Template Group anlegen (Bsp. Eigene) → je Template: Live Template <br>
> **Hinweis**: Abkürzungen und Beschreibung könnt ihr setzen wie ihr wollt.
> **Mindestens**:
> - Abbreviation (müsst ihr schnell darauf kommen, meine Beispiele habe ich dazu geschrieben)
> - Template text (das Code Fragment)
> - Application Context (mind. Java angeben)

---

> ### Abkürzung: nioRead
> Beschreibung: Den Dateiinhalt lesen mit java.nio
``` java
String filename = "$FILENAME$.txt";
try {
    Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
            .forEach(line -> tokens.add(parseToken(line))); // z.B.
} 
catch (NumberFormatException | IOException ex) {
    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
} 
```
---

> ### Abkürzung: nioWrite
> Beschreibung: Eine Zeile in eine Datei schreiben mit java.nio
``` java
String filename = "$FILENAME$.txt";
String line = "$CONTENT$";
try {
    Files.writeString(Paths.get(filename), 
        line + System.lineSeparator(), 
        StandardOpenOption.APPEND, 
        StandardOpenOption.CREATE
    );
} catch (IOException ex) {
    JOptionPane.showMessageDialog(null, ex.getMessage());
}
```
---

> ### Abkürzung: optionInfo
> Beschreibung: Erstellt eine JOptionPane, die nur zur Information dient
``` java
JOptionPane.showMessageDialog(null, "Anzeigetext", "Titel", JOptionPane.INFORMATION_MESSAGE);
```
---

> ### Abkürzung: optionYesNo
> Beschreibung: Erstellt ein JOptionPane mit verschiedenen Überprüfungen (und Optionsprüfung für Ja-Option)
``` java
String[] opts = { "Ja", "Nein"};
int popup = JOptionPane.showOptionDialog(null, "Anzeigetext","Titel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
if (popup == JOptionPane.YES_OPTION) {
    System.exit(0);
}
```
---

> ### Abkürzung: initGUI
> Beschreibung: mit 'extends JFrame' Codeerweiterung für den Konstrukter
``` java
this.setTitle("Fenstertitel");
this.setLayout(new FlowLayout());
JPanel mainPanel = new JPanel();

this.add(mainPanel);
// this.pack();
this.setSize(500, 600);
this.setLocationRelativeTo(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
```
---