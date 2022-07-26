package com.plcoding.daggerscopes.ui

import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.plcoding.daggerscopes.R
import com.plcoding.daggerscopes.SessionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoCallFragment: Fragment() {

    private val viewModel: SessionViewModel by navGraphViewModels(R.navigation.nested_graph)
}