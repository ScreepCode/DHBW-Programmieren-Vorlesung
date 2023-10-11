# Live Templates
> **Anleitung**: IntelliJ → Settings → Live Templates → Template Group anlegen (Bsp. Eigene) → je Template: Live Template
> 
> **Hinweis**: Abkürzungen und Beschreibung könnt ihr setzen wie ihr wollt.
> 
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
    java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filename)) // als Stream weiterverarbeiten
            .forEach(line -> tokens.add(parseToken(line))); // z.B.
} catch (NumberFormatException | java.io.IOException ex) {
    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
}
```
---

> ### Abkürzung: nioWrite
> Beschreibung: Eine Zeile in einer Datei anhängen mit java.nio
``` java
String filename = "$FILENAME$.txt";
String line = "$CONTENT$";
try {
    java.nio.file.Files.writeString(java.nio.file.Paths.get(filename),
            line + System.lineSeparator(),
            java.nio.file.StandardOpenOption.APPEND,
            java.nio.file.StandardOpenOption.CREATE
    );
} catch (java.io.IOException ex) {
    javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
}
```
---

> ### Abkürzung: optionInfo
> Beschreibung: Erstellt eine JOptionPane, die nur zur Information dient
``` java
javax.swing.JOptionPane.showMessageDialog(null, "Anzeigetext", "Titel", javax.swing.JOptionPane.INFORMATION_MESSAGE);
```
---

> ### Abkürzung: optionYesNo
> Beschreibung: Erstellt ein JOptionPane mit verschiedenen Überprüfungen (und Optionsprüfung für Ja-Option)
``` java
String[] opts = { "Ja", "Nein"};
int popup = javax.swing.JOptionPane.showOptionDialog(null, "Anzeigetext","Titel", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
if (popup == javax.swing.JOptionPane.YES_OPTION) {
    System.exit(0);
}
```
---

> ### Abkürzung: initGUI
> Beschreibung: mit 'extends JFrame' Codeerweiterung für den Konstrukter
``` java
this.setTitle(String.format("%s", "Titel"));
javax.swing.JPanel northPanel = new JPanel();
JPanel centerPanel = new JPanel();
JPanel southPanel = new JPanel();

this.add(northPanel, java.awt.BorderLayout.NORTH);
this.add(centerPanel, BorderLayout.CENTER);
this.add(southPanel, BorderLayout.SOUTH);
// this.pack();
this.setSize(500, 600);
this.setLocationRelativeTo(null);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
```
---

> ### Abkürzung: buttonGroupEnum
> Beschreibung: ButtonGroup with Enum (mehr Anpassung im Anwendungsfall erforderlich)
``` java
// actionPanel = renderButtons();
private javax.swing.JPanel renderButtons() {
    javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
    buttonGroup = new javax.swing.ButtonGroup();
    for(ResultType type : ResultType.values()){   // for all enum values
        if(type == ResultType.UNKNOWN) continue;  // used to skip enum values
        javax.swing.JRadioButton radioButton = new javax.swing.JRadioButton(type.getLabel());
        radioButton.setActionCommand(type.getLabel()); // way to get a String from selected button to check
        buttonGroup.add(radioButton);
        buttonPanel.add(radioButton);
    }
    return buttonPanel;
}

// Im Aktion Listener:
// if(buttonGroup.getSelection() != null){
//   if (actionCommand.equals(ResultType.HOME.getLabel())){
//        activeMatch.setResultType(ResultType.HOME);
//    }
//    ...
```
---

> ### Abkürzung: bufferRead
> Beschreibung: Den Dateiinhalt lesen mit java.io (BufferedReader)
``` java
StringBuilder content = new StringBuilder();
try(java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("$FILENAME$.txt"))){
    while (bufferedReader.ready()){
        content.append(bufferedReader.readLine()).append(System.lineSeparator());
    }
}
catch (java.io.IOException e) {
    e.printStackTrace();
}
// content.toString()
```
---

> ### Abkürzung: bufferWrite
> Beschreibung: Eine Zeile in einer Datei anhängen mit java.io (BufferedWriter)
``` java
String line = "";
try(java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter("$FILENAME$.txt", true))){
    bufferedWriter.write(line + System.lineSeparator());            
} catch (java.io.IOException e) {
    e.printStackTrace();
}
```
---