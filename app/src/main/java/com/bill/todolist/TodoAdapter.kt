package com.bill.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bill.todolist.data.Todo
import com.bill.todolist.databinding.TodoItemBinding

class TodoAdapter(private var list: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {
  private lateinit var binding: TodoItemBinding

  constructor(): this(emptyList<Todo>())

  inner class TodoHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
    binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return TodoHolder(binding.root)
  }

  override fun onBindViewHolder(holder: TodoHolder, position: Int) {
    binding.apply {
      textView.text = list[position].item
      checkBox.isChecked = list[position].isChecked
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun changeData(newList: List<Todo>) {
    list = newList
    notifyDataSetChanged()
  }
}
