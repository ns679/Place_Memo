package com.aaa165.placememo.util

import androidx.fragment.app.Fragment

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val memoRepository =
        ServiceLoader.provideMemoRepository(requireContext())
    return ViewModelFactory(memoRepository)
}