package com.example.daan.journal;

import java.io.Serializable;
import java.sql.Timestamp;

public class JournalEntry implements Serializable {
    private String title, content;
    private Timestamp timestamp;
    private Integer id, mood;

    // Constructor
    public JournalEntry(String title, String content, Timestamp timestamp, Integer id, Integer mood) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.id = id;
        this.id = mood;
    }
    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMood() {
        return mood;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }
}
