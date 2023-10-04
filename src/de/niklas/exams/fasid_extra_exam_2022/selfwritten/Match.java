package de.niklas.exams.fasid_extra_exam_2022.selfwritten;

public class Match {

    private String homeTeam, guestTeam, date, time, stadium, result;

    private ResultType resultType;

    public Match(String homeTeam, String guestTeam, String date, String time, String stadium, String result) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.result = result;
        resultType = ResultType.UNKNOWN;
    }

    public boolean hasResult(){
        return result != null;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", homeTeam, guestTeam);
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public String getMatchInformation(){
        return String.format("%s - %s @ %s", date, time, stadium);
    }
}
