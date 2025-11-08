package com.example.todoapp;

/**
 * Java class representing a Todo item
 * Demonstrates Java-Kotlin interoperability
 */
public class TodoItem {
    private String text;
    private boolean isCompleted;
    private long id;

    public TodoItem(String text) {
        this.text = text;
        this.isCompleted = false;
        this.id = System.currentTimeMillis();
    }

    public TodoItem(String text, boolean isCompleted, long id) {
        this.text = text;
        this.isCompleted = isCompleted;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void toggleCompleted() {
        isCompleted = !isCompleted;
    }
}

