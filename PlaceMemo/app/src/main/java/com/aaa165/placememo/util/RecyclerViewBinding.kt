package com.aaa165.placememo.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aaa165.placememo.service.model.Memo
import com.aaa165.placememo.view.adapter.MemoListAdapter

@BindingAdapter("app:memo_items")
fun setMemoItems(listView: RecyclerView, items:List<Memo>?){
    if(items!=null)
        (listView.adapter as MemoListAdapter).submitList(items)
}