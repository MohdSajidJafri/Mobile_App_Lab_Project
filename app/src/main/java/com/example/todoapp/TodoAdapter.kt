package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTodoBinding

/**
 * RecyclerView Adapter written in Kotlin
 * Demonstrates Kotlin features like lambda expressions and data classes
 */
class TodoAdapter(
    private val todos: List<TodoItem>,
    private val onToggleClick: (TodoItem) -> Unit,
    private val onDeleteClick: (TodoItem) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: TodoItem) {
            binding.textViewTodo.text = todo.text
            
            // Update text appearance based on completion status
            if (todo.isCompleted()) {
                binding.textViewTodo.alpha = 0.5f
                binding.textViewTodo.text = "✓ ${todo.text}"
                binding.buttonToggle.text = "Mark Incomplete"
            } else {
                binding.textViewTodo.alpha = 1.0f
                binding.textViewTodo.text = todo.text
                binding.buttonToggle.text = "Mark Complete"
            }

            binding.buttonToggle.setOnClickListener {
                onToggleClick(todo)
            }

            binding.buttonDelete.setOnClickListener {
                onDeleteClick(todo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size
}

