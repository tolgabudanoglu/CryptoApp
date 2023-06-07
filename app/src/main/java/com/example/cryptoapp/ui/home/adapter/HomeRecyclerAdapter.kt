package com.example.cryptoapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.RecyclerRowLayoutBinding
import com.example.cryptoapp.model.home.Data
import com.example.cryptoapp.ui.home.ItemClickListener

class HomeRecyclerAdapter(private val listener:ItemClickListener ):RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>() {

    private var coins = emptyList<Data>()

    class MyViewHolder(private val binding:RecyclerRowLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: ItemClickListener,coin:Data){
            binding.onItemClickListener = listener
            binding.coin = coin
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup):MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerRowLayoutBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(listener, coins[position])

    override fun getItemCount() = coins.size


    fun setList(newList:List<Data>){
        coins = newList
        notifyDataSetChanged()
    }



}