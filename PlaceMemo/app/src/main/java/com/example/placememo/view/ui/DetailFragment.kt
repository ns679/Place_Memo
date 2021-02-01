package com.example.placememo.view.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.placememo.databinding.FragmentDetailBinding
import com.example.placememo.util.getViewModelFactory
import com.example.placememo.viewmodel.DetailViewModel

class DetailFragment :Fragment() {
    private val viewModel : DetailViewModel by viewModels{getViewModelFactory()}
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var fragmentDetailBinding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater,container,false).apply {
            viewModel = this@DetailFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val memoId = args.memoId
        viewModel.start(memoId)
    }
}