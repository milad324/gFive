package com.example.gfive.bindingadapters

import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.databinding.BindingAdapter

class CardRowLayoutBinding {
    companion object {
        @BindingAdapter("convertStageToSting")
        @JvmStatic
        fun convertStageToSting(textView: TextView, stage: Short) {
            when (stage) {
                in 1..4 -> textView.setTextColor(Color.Red.toArgb())
                in 5..8 -> textView.setTextColor(Color.Blue.toArgb())
                else -> textView.setTextColor(Color.Green.toArgb())
            }
            textView.text = "Stage : $stage"
        }
    }
}

