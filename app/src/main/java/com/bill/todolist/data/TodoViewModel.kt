package com.bill.todolist.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
  /**
   * To provide data to the UI and survive configuration changes
   * It is a communication center between the repository and the UI
   */

  val readAllData: LiveData<List<Todo>>
  private val repository: TodoRepository

  init {
    val todoDao = TodoDatabase.getDatabase(application).todoDao()
    repository = TodoRepository(todoDao)
    readAllData = repository.readAllData()
  }

  fun addTodo(todo: Todo) {
    viewModelScope.launch(Dispatchers.IO) {
      repository.addTodo(todo )
    }
  }
}