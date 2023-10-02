package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

public interface IRoom {

    double getDose(int x, int y);
    void setDose(int x, int y, double dose);
    void addDose(int x, int y, double dose);
    void step();
}
