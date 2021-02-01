package com.example.placememo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placememo.service.model.Memo
import com.example.placememo.service.repository.MemoRepository
import com.example.placememo.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val repository: MemoRepository):ViewModel() {
    private var _allItems = MutableLiveData<List<Memo>>()
    val allItems : LiveData<List<Memo>> =_allItems

    private var _openDetailEvent = MutableLiveData<Event<String>>(Event(""))
    val openDetailEvent : LiveData<Event<String>> =_openDetailEvent

    private var _onAddEvent = MutableLiveData<Event<Boolean>>(Event(false))
    val onAddEvent : LiveData<Event<Boolean>> = _onAddEvent

    fun start(){
        viewModelScope.launch(Dispatchers.IO){
            _allItems.postValue(repository.getAll())
        }
    }

    fun onFabClicked(){
        _onAddEvent.value = Event(true)
    }

    fun openDetail(memoId:String){
        _openDetailEvent.value = Event(memoId)
    }
}