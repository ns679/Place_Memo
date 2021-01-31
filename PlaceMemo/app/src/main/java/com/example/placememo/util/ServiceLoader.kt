package com.example.placememo.util

import android.content.Context
import com.example.placememo.service.AppDatabase
import com.example.placememo.service.repository.MemoRepository

object ServiceLoader {
    private var database : AppDatabase? = null
    var memoRepository:MemoRepository? = null

    fun provideMemoRepository(context:Context):MemoRepository{
        synchronized(this){
            return memoRepository
                ?: createMemoRepository(
                    context
                )
        }
    }
    private fun createMemoRepository(context:Context):MemoRepository{
        val database = database
            ?: createDatabase(
                context
            )
        val result = MemoRepository(database.memoDao())
        memoRepository = result
        return result
    }


    private fun createDatabase(context:Context):AppDatabase{
        val result = AppDatabase.getDatabase(context)
        database =result
        return result
    }
}