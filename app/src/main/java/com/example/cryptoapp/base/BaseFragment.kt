package com.example.cryptoapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewBinding :ViewBinding, viewModel : ViewModel>(
    private val bindingInflater: (inflater : LayoutInflater) -> viewBinding
):Fragment() {

    private var _binding:viewBinding? = null
    protected val binding:viewBinding get() = _binding as viewBinding

    protected abstract val viewModel:viewModel
    protected abstract fun onCreateFinsihed()
    protected abstract fun initializeListeners()
    protected abstract fun observeEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = bindingInflater.invoke(inflater)

        if (_binding == null){
            throw IllegalArgumentException("binding null")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreateFinsihed()
        observeEvent()
        initializeListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    abstract fun observeEvents()
}