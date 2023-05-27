package com.example.gfive.bindingadapters

import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.gfive.data.database.entities.DeckEntity
import com.example.gfive.ui.fragments.deck.DeckFragmentDirections
import java.text.SimpleDateFormat
import java.util.Date

class DeckRowLayoutBinding {
    companion object {
        @BindingAdapter("changeLongToStringDate")
        @JvmStatic
        fun changeLongToStringDate(textView: TextView, dateLong: Long) {
            val date = Date(dateLong)
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
            textView.text = format.format(date)
        }

        @BindingAdapter("navigateToCard")
        @JvmStatic
        fun navigateToCard(imageView: ImageView, deck: DeckEntity) {
            imageView.setOnClickListener {
                var action = DeckFragmentDirections.actionDeckFragmentToCardFragment(deck)
                imageView.findNavController().navigate(action)
            }
        }
    }
}