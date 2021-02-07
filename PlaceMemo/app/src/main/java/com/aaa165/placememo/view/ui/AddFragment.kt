package com.aaa165.placememo.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aaa165.placememo.databinding.FragmentAddBinding
import com.aaa165.placememo.util.EventObserver
import com.aaa165.placememo.util.getViewModelFactory
import com.aaa165.placememo.viewmodel.AddViewModel


class AddFragment : Fragment() {
    private val viewModel : AddViewModel by viewModels{getViewModelFactory()}

    private lateinit var fragmentAddBinding: FragmentAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentAddBinding = FragmentAddBinding.inflate(inflater,container,false).apply {
            viewModel = this@AddFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return fragmentAddBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        endInsert()
        failedInsert()
        viewModel.title.observe(this, Observer{ viewModel.validation() })
    }

    private fun endInsert(){
        viewModel.endInsert.observe(this,EventObserver{
            if(it){
                Toast.makeText(this.context,"タスクを追加しました。", Toast.LENGTH_LONG).show()
                navigateToList()
            }
        })
    }

    private fun failedInsert(){
        viewModel.failedInsert.observe(this, EventObserver{
            if(it){
                Toast.makeText(this.context,"タスクを追加できませんでした。", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun navigateToList(){
        val action = AddFragmentDirections
            .actionAddFragmentToListFragment()
        findNavController().navigate(action)
    }

}