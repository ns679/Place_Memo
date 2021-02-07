package com.aaa165.placememo.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aaa165.placememo.service.repository.MemoRepository
import com.aaa165.placememo.viewmodel.AddViewModel
import com.aaa165.placememo.viewmodel.DetailViewModel
import com.aaa165.placememo.viewmodel.ListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val memoRepository: MemoRepository
): ViewModelProvider.NewInstanceFactory(){

        override fun <T: ViewModel> create(modelClass:Class<T>): T {
            val t = with(modelClass) {
                when {
                    isAssignableFrom(AddViewModel::class.java) ->
                        AddViewModel(memoRepository)
                    isAssignableFrom(DetailViewModel::class.java) ->
                        DetailViewModel(memoRepository)
                    isAssignableFrom(ListViewModel::class.java) ->
                        ListViewModel(memoRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModelClass $modelClass")
                }
            } as T
            return t
        }
}