package com.bill.todolist.data

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {
  /**
   * This is a class created to abstract the access to multiple data sources
  */

  fun readAllData(): LiveData<List<Todo>> = todoDao.getAll()

  suspend fun addTodo(todo: Todo) {
    todoDao.add(todo)
  }

}