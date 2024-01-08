package com.example.authproj.models;

import com.example.authproj.models.Student;
import javax.persistence.*;
import java.util.List;

@Entity
public class Grupa {

    @Id
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupa_title")
    private List<Student> students;

    public Grupa() {
    }

    public Grupa(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
