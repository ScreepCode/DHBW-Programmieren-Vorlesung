package de.niklas.exams.fakeTalk_exam_2022.selfwritten;

public interface FakeTalkClient {
    String getPlayerName();
    void setQuote(Quote q);
    void addPoints(int points);
    int getPoints();
}
