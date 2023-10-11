package de.niklas.exams.cts_extra_exam_2019;

public class Company {

    private String name, abbr, location;

    public Company(String name, String abbr, String location) {
        this.name = name;
        this.abbr = abbr;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, abbr);
    }
}
