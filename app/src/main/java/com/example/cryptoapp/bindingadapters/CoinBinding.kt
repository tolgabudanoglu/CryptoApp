package com.example.cryptoapp.bindingadapters

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cryptoapp.utils.loadImage

class CoinBinding {
    companion object{

        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView,coinImage: String){
            val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/128x128/$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}