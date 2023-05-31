package com.example.gfive.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.gfive.data.database.entities.DeckEntity

class CardLayoutBinding {
    companion object {
        @BindingAdapter("convertDeckName")
        @JvmStatic
        fun convertDeckName(textView: TextView, deckEntity: DeckEntity) {
            textView.text = "${deckEntity.deckName}'s cards management"
        }

        @BindingAdapter("convertIntToText")
        @JvmStatic
        fun convertIntToText(textView: TextView, number: Int) {
            textView.text = number.toString()
        }
    }
}