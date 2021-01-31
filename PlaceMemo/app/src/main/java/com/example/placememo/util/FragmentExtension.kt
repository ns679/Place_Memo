package com.example.placememo.util

import androidx.fragment.app.Fragment
import java.util.*

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val memoRepository =
        ServiceLoader.provideMemoRepository(requireContext())
    return ViewModelFactory(memoRepository)
}