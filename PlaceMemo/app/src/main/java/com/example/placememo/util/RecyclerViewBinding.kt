package com.example.placememo.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.placememo.service.model.Memo

@BindingAdapter("app:memo_items")
fun setMemoItems(listView: RecyclerView, items:List<Memo>?){
    if(items!=null)
        (listView.adapter as MemoListAdapter).submitList(items)
}