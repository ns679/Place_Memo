package com.aaa165.placememo.service.repository

import com.aaa165.placememo.service.dao.MemoDao
import com.aaa165.placememo.service.model.Memo

class MemoRepository(private val memoDao: MemoDao) {

    fun getAll():List<Memo>{
        return memoDao.getAll()
    }

    fun getById(memoId:String):Memo{
        return memoDao.getById(memoId)
    }

    fun insert(memo:Memo){
        memoDao.insert(memo)
    }

}