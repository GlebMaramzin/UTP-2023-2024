package com.example.authproj.models;

import javax.persistence.*;

@Entity
public class Discipline {

    @Id
    private String title;

    public Discipline() {
    }

    public Discipline(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
