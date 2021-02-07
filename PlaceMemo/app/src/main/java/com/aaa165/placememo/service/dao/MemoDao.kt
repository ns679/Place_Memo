package com.aaa165.placememo.service.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aaa165.placememo.service.model.Memo

    @Dao
    interface MemoDao{

        @Query("SELECT * FROM memo_table")
        fun getAll():List<Memo>

        @Query("SELECT * FROM memo_table WHERE memo_id =(:memoId)")
        fun getById(memoId:String):Memo

        @Insert
        fun insert(memo: Memo)
    }