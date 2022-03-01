package com.bill.todolist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(), Runnable {
  override fun run() {

  }

  abstract fun todoDao(): TodoDao
}