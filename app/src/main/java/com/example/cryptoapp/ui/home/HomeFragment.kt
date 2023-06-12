package com.example.cryptoapp.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.cryptoapp.base.BaseFragment
import com.example.cryptoapp.databinding.FragmentHomeBinding
import com.example.cryptoapp.model.home.Data
import com.example.cryptoapp.ui.home.adapter.HomeRecyclerAdapter
import com.example.cryptoapp.utils.Constant.API_KEY
import com.example.cryptoapp.utils.Constant.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UNCHECKED_CAST")
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData(API_KEY,LIMIT)
    }

    override fun onCreateFinsihed() {

    }

    override fun initializeListeners() {

    }

    override fun observeEvent() {
        with(viewModel) {
            cryptoResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.data?.let { it1 -> setRecycler(it1 as List<Data>) }
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleView(it)
            })

            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })
        }
    }

    override fun observeEvents() {
        with(viewModel) {
            cryptoResponse.observe(viewLifecycleOwner, Observer {
                it?.let {
                    it.data?.let { it1 -> setRecycler(it1 as List<Data>) }
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer {
                handleView(it)
            })

            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            })
        }
    }


    private fun setRecycler(data: List<Data>){
         val myAdapter = HomeRecyclerAdapter(object :ItemClickListener{
             override fun onItemClick(coin: Data) {
                 if (coin.symbol !=null){
                     val navigation = HomeFragmentDirections.actionHomeFragmentToDetailFragment(coin.symbol)
                     Navigation.findNavController(requireView()).navigate(navigation)
                 }


             }
         })
        binding.rVHome.adapter = myAdapter
        myAdapter.setList(data as List<Data>)
    }

    private fun handleView(isLoading:Boolean = false){
        binding.rVHome.isVisible = !isLoading
        binding.pBHome.isVisible = isLoading
    }

}