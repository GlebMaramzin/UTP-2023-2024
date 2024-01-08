package com.example.authproj.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    private String studbilet;

    private String FIO;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studbilet")
    private List<Progress> progresses;

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }

    public Student() {
    }

    public String getStudbilet() {
        return studbilet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studbilet='" + studbilet + '\'' +
                ", FIO='" + FIO + '\'' +
                '}';
    }

    public void setStudbilet(String studbilet) {
        this.studbilet = studbilet;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Student(String studbilet, String FIO) {
        this.studbilet = studbilet;
        this.FIO = FIO;
    }
}
