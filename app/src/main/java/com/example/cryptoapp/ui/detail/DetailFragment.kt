package com.example.cryptoapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cryptoapp.R
import com.example.cryptoapp.base.BaseFragment
import com.example.cryptoapp.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()


    override fun onCreateFinsihed() {

    }

    override fun initializeListeners() {

    }

    override fun observeEvent() {

    }

    override fun observeEvents() {

    }
}