package de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten;

public interface GameClient {
    public String getPlayerName();
    public int getPoints();
    public void setQuestion(int questionIndex, Question q);
    public void gameIsOver();
    public void setAnswerState(int questionIndex, Status status);

    public void setRemainingSeconds(int time);
}
