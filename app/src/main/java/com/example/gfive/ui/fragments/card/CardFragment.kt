package com.example.gfive.ui.fragments.card

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gfive.adapters.CardAdapter
import com.example.gfive.databinding.FragmentCardBinding
import com.example.gfive.viewModels.card.CardViewModel
import com.example.gfive.viewModels.deck.DeckViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CardFragment : Fragment() {


    private val args by navArgs<CardFragmentArgs>()
    private lateinit var binding: FragmentCardBinding
    private val viewModel: CardViewModel by viewModels()
    private val deckViewModel: DeckViewModel by viewModels()
    private val mAdapter: CardAdapter by lazy { CardAdapter(viewModel) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCardBinding.inflate(layoutInflater, container, false)
        binding.deckEntity = args.deck
        binding.rvCard.adapter = mAdapter
        binding.fabAddCard.setOnClickListener {
            val action = CardFragmentDirections.actionCardFragmentToAddCardFragment(args.deck)
            findNavController().navigate(action)
        }
        viewModel.cards.observe(viewLifecycleOwner) {
            mAdapter.setData(it.cards)
        }
        deckViewModel.deckStatus.observe(viewLifecycleOwner) {
            binding.deckCardStatus = it
        }
        loadCardByDeck()
        return binding.root
    }


    private fun loadCardByDeck() {
        lifecycleScope.launch {
            deckViewModel.getDeckCardStatus(args.deck.id)
        }
        lifecycleScope.launch {
            viewModel.getCardsByDeckId(args.deck.id)
        }
    }

}