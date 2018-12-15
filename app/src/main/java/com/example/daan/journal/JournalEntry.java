package com.example.daan.journal;

import java.io.Serializable;

// Implements Serializable to be able to pass instances of this class using an intent.
public class JournalEntry implements Serializable {
    private String title, content, timestamp;
    private Integer id, mood;

    // Constructor
    public JournalEntry(String title, String content,String timestamp, Integer id, Integer mood) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.id = id;
        this.mood = mood;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getMood() {
        return mood;
    }

    public Integer getId() {
        return id;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
