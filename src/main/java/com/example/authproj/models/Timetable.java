package com.example.authproj.models;

import javax.persistence.*;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String weekday;

    @ManyToOne()
    @JoinColumn(name = "discipline_title")
    private Discipline discipline;

    @ManyToOne()
    @JoinColumn(name = "grupa_title")
    private Grupa grupa;

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
