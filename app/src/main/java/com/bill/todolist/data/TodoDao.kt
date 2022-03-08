package com.bill.todolist.data


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun add(todo: Todo)

  @Insert
  fun insertAll(vararg todos: Todo)

  @Delete
  fun delete(todo: Todo)

  @Query("SELECT * FROM todo")
  fun getAll(): LiveData<List<Todo>>
}