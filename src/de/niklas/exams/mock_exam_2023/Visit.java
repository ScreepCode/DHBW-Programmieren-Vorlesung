package de.niklas.exams.mock_exam_2023;

/**
 * <strong>Visit</strong><br>
 * Die Implementation eines Spielwurfes
 *
 * @see "Teilaufgabe c"
 * @author Niklas Buse
 */
public class Visit {
    private Field[] fields;
    public Visit(Field[] fields) {
        if(fields.length > 3){
            throw new IllegalArgumentException("Die Anzahl ist ungültig für einen Versuch");
        }
        else{
            this.fields = fields;
        }
    }

    public Field[] getFields() {
        return fields;
    }

    public int getValue(){
        int value = 0;
        for(Field field : fields){
            value += field.getValue();
        }
        return value;
    }

    public Field getLastField(){
        return fields[fields.length-1];
    }
}
