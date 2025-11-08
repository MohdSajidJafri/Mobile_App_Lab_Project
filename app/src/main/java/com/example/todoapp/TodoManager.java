package com.example.todoapp;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class for managing Todo items using SharedPreferences
 * Demonstrates data persistence and Java-Kotlin interoperability
 */
public class TodoManager {
    private static final String PREFS_NAME = "TodoPrefs";
    private static final String KEY_TODOS = "todos";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public TodoManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void addTodo(TodoItem todo) {
        List<TodoItem> todos = getTodos();
        todos.add(todo);
        saveTodos(todos);
    }

    public void removeTodo(TodoItem todo) {
        List<TodoItem> todos = getTodos();
        todos.removeIf(item -> item.getId() == todo.getId());
        saveTodos(todos);
    }

    public void updateTodo(TodoItem todo) {
        List<TodoItem> todos = getTodos();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todo.getId()) {
                todos.set(i, todo);
                break;
            }
        }
        saveTodos(todos);
    }

    public List<TodoItem> getTodos() {
        String json = sharedPreferences.getString(KEY_TODOS, null);
        if (json == null) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<TodoItem>>(){}.getType();
        List<TodoItem> todos = gson.fromJson(json, type);
        return todos != null ? todos : new ArrayList<>();
    }

    private void saveTodos(List<TodoItem> todos) {
        String json = gson.toJson(todos);
        sharedPreferences.edit().putString(KEY_TODOS, json).apply();
    }
}

