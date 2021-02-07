package com.aaa165.placememo.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aaa165.placememo.service.dao.MemoDao
import com.aaa165.placememo.service.model.Memo

@Database(entities = [Memo::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun memoDao():MemoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}