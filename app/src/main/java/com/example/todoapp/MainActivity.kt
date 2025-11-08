package com.example.todoapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding

/**
 * MainActivity written in Kotlin
 * Demonstrates Kotlin-Java interoperability by using Java classes
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoManager: TodoManager
    private lateinit var todoAdapter: TodoAdapter
    private val todos = mutableListOf<TodoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize TodoManager (Java class)
        todoManager = TodoManager(this)

        // Setup RecyclerView
        setupRecyclerView()

        // Load existing todos
        loadTodos()

        // Setup add button click listener
        binding.buttonAdd.setOnClickListener {
            addTodo()
        }
    }

    private fun setupRecyclerView() {
        todoAdapter = TodoAdapter(todos) { todo ->
            toggleTodo(todo)
        } { todo ->
            deleteTodo(todo)
        }
        binding.recyclerViewTodos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewTodos.adapter = todoAdapter
    }

    private fun addTodo() {
        val todoText = binding.editTextTodo.text.toString().trim()
        if (todoText.isEmpty()) {
            Toast.makeText(this, "Please enter a todo item", Toast.LENGTH_SHORT).show()
            return
        }

        val todo = TodoItem(todoText)
        todoManager.addTodo(todo)
        todos.add(todo)
        todoAdapter.notifyItemInserted(todos.size - 1)
        binding.editTextTodo.text.clear()
        updateEmptyState()
    }

    private fun toggleTodo(todo: TodoItem) {
        todo.toggleCompleted()
        todoManager.updateTodo(todo)
        val position = todos.indexOf(todo)
        todoAdapter.notifyItemChanged(position)
    }

    private fun deleteTodo(todo: TodoItem) {
        val position = todos.indexOf(todo)
        if (position != -1) {
            todoManager.removeTodo(todo)
            todos.removeAt(position)
            todoAdapter.notifyItemRemoved(position)
            updateEmptyState()
        }
    }

    private fun loadTodos() {
        val loadedTodos = todoManager.getTodos()
        todos.clear()
        todos.addAll(loadedTodos)
        todoAdapter.notifyDataSetChanged()
        updateEmptyState()
    }

    private fun updateEmptyState() {
        if (todos.isEmpty()) {
            binding.textViewEmpty.visibility = View.VISIBLE
            binding.recyclerViewTodos.visibility = View.GONE
        } else {
            binding.textViewEmpty.visibility = View.GONE
            binding.recyclerViewTodos.visibility = View.VISIBLE
        }
    }
}

