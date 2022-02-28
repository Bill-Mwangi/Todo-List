package com.bill.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bill.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    binding = ActivityMainBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    val todoItems = mutableListOf(
      Todo("Homework"),
      Todo("Create todo app", true),
      Todo("Learnt about recyclerviews", true)
    )

    binding.rvTodos.layoutManager = LinearLayoutManager(this)
    val adapter = TodoAdapter(todoItems)
    binding.rvTodos.adapter = adapter

    binding.btnSave.setOnClickListener {
      val newTodo: String = binding.etNewTodo.text.toString()
      todoItems.add(Todo(newTodo))
      adapter.notifyItemInserted(todoItems.size - 1)
    }
  }
}