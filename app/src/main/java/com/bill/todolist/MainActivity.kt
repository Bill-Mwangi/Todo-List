package com.bill.todolist

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bill.todolist.data.Todo
import com.bill.todolist.data.TodoViewModel
import com.bill.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private lateinit var viewModel: TodoViewModel
  private lateinit var todoAdapter: TodoAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    binding = ActivityMainBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

    //RecyclerView Configuration
    binding.rvTodos.layoutManager = LinearLayoutManager(this)
    todoAdapter = TodoAdapter()
    binding.rvTodos.adapter = todoAdapter

    viewModel.readAllData.observe(this) {
      todoAdapter.changeData(it)
    }

    binding.btnSave.setOnClickListener {
      val todoString: String = binding.etNewTodo.text.toString()

      if (!TextUtils.isEmpty(todoString)) {
        val todo = Todo(todoString)
        viewModel.addTodo(todo)
        binding.etNewTodo.text.clear()
      }
    }
  }
}