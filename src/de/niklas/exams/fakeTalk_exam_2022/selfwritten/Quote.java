package de.niklas.exams.fakeTalk_exam_2022.selfwritten;
public class Quote {

    private String text, person, role, source;
    private QuoteType quoteType;

    public Quote(String text, String person, String role, String source, QuoteType quoteType) {
        this.text = text;
        this.person = person;
        this.role = role;
        this.source = source;
        this.quoteType = quoteType;
    }

    public String getCitation(){
        return String.format("This quote is %s!\nFrom: %s (%s)", quoteType.getName(), person, source);
    }

    public String getText() {
        return text;
    }

    public QuoteType getQuoteType() {
        return quoteType;
    }
}
