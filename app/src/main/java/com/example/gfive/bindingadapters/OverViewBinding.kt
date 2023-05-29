package com.example.gfive.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

class OverViewBinding {
    companion object {

        @JvmStatic
        @BindingAdapter("changeIntToText")
        fun changeIntToText(textview: TextView, value: Int) {
            textview.text = value.toString()
        }
    }
}