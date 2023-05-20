package com.example.gfive.ui.fragments.deck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gfive.R
import com.example.gfive.databinding.FragmentDeckBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DeckFragment : Fragment() {

    private lateinit var binding: FragmentDeckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeckBinding.inflate(inflater, container, false)
        binding.fabAddDeck.setOnClickListener {
            findNavController().navigate(R.id.action_deckFragment_to_addDeckDialog)
        }


        return binding.root
    }

}