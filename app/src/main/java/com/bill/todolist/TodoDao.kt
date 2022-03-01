package com.bill.todolist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
  @Insert
  fun insert(todo: Todo)

  @Insert
  fun insertAll(vararg todos: Todo)

  @Delete
  fun delete(todo: Todo)

  @Query("SELECT * FROM todo")
  fun getAll(): List<Todo>
}