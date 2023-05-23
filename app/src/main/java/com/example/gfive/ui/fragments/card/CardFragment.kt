package com.example.gfive.ui.fragments.card

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.gfive.R
import com.example.gfive.data.database.entities.DeckEntity

class CardFragment : Fragment() {


    private val args by navArgs<CardFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var deck= args.deck
        Toast.makeText(this.context, deck.deckName,Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

}