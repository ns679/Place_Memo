package com.aaa165.placememo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.aaa165.placememo.service.repository.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MemoRepository) : ViewModel() {
    private var _title = MutableLiveData<String>()
    val title :LiveData<String> = _title
    private var _memo = MutableLiveData<String>()
    val memo :LiveData<String> = _memo

    fun start(memoId:String){
        viewModelScope.launch(Dispatchers.IO){
            val memo = repository.getById(memoId)
            _title.postValue(memo.title)
            _memo.postValue(memo.memo)
        }
    }
}