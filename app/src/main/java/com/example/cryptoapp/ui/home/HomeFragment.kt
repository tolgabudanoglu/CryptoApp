package com.example.cryptoapp.ui.home

import androidx.fragment.app.viewModels
import com.example.cryptoapp.base.BaseFragment
import com.example.cryptoapp.databinding.FragmentHomeBinding
import com.example.cryptoapp.utils.Constant.API_KEY
import com.example.cryptoapp.utils.Constant.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreateFinsihed() {
        viewModel.getData(API_KEY,LIMIT)
    }

    override fun initializeListeners() {

    }

    override fun observeEvent() {

    }

}