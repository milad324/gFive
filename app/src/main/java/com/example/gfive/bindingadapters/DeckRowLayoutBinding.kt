package com.example.gfive.bindingadapters

import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.Date

class DeckRowLayoutBinding {
    companion object {
        @BindingAdapter("changeLongToStringDate")
        @JvmStatic
        fun changeLongToStringDate(textView: TextView, dateLong: Long) {
            val date = Date(dateLong)
            textView.text = date.toString()
        }
    }
}