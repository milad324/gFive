package com.example.gfive.bindingadapters

import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckEntity
import com.example.gfive.ui.fragments.card.CardFragmentDirections
import com.example.gfive.ui.fragments.deck.DeckFragmentDirections

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

        @BindingAdapter("addQuestion")
        @JvmStatic
        fun addQuestion(textView: TextView, question: String) {

            textView.text = "question : $question"
        }

        @BindingAdapter("addAnswer")
        @JvmStatic
        fun addAnswer(textView: TextView, question: String) {

            textView.text = "answer : $question"
        }

        @BindingAdapter("editeCard")
        @JvmStatic
        fun editeCard(btn: ImageButton, card: CardEntity) {
            btn.setOnClickListener {
                val action = CardFragmentDirections.actionCardFragmentToEditCardFragment(card)
                btn.findNavController().navigate(action)
            }
        }
    }
}

