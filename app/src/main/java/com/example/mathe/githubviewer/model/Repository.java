package com.example.mathe.githubviewer.model;

import java.io.Serializable;

public class Repository implements Serializable {

    private Long id;
    private String name;
    private String language;

    public String getLanguage() {return language; }

    public void setLanguage(String language) {this.language = language; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

