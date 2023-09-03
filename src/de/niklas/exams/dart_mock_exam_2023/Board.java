package de.niklas.exams.dart_mock_exam_2023;

/**
 * <strong>Board</strong><br>
 * Implementation eines Dart Boards inkl. generierung
 *
 * @see "Teilaufgabe b"
 * @author Niklas Buse
 */
public class Board {

    private Field[] fields = new Field[63];

    public Board(){
        for(int i = 1; i <= 20; i++){
            fields[i-1] = new Field(""+ i, i, false);
            fields[i-1+20] = new Field("D"+ i, i*2, true);
            fields[i-1+40] = new Field("T"+ i, i*3, false);
        }
        fields[60] = new Field("25", 25, false);
        fields[61] = new Field("BULL", 50, true);
        fields[62] = new Field("x", 0, false);
    }

    public Field parseField(String label){
        for(int i = 0; i < fields.length; i++){
            if(label.toUpperCase().equals(fields[i].getLabel())){
                return fields[i];
            }
        }
        return null;
    }
}
