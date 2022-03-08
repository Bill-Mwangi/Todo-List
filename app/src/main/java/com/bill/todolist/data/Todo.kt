package com.bill.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
  @ColumnInfo(name = "todo_item") val item: String,
  @ColumnInfo(name = "is_done") val isChecked: Boolean = false,
  @PrimaryKey(autoGenerate = true) val id: Int = 0
)