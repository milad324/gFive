package com.example.gfive.ui.fragments.deck

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gfive.R
import com.example.gfive.adapters.DeckAdapter
import com.example.gfive.databinding.FragmentDeckBinding
import com.example.gfive.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DeckFragment : Fragment() {

    private lateinit var binding: FragmentDeckBinding
    private val mAdapter: DeckAdapter by lazy { DeckAdapter(mainViewModel) }
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeckBinding.inflate(inflater, container, false)
        binding.fabAddDeck.setOnClickListener {
            findNavController().navigate(R.id.action_deckFragment_to_addDeckDialog)
        }

        setupRecyclerView()
        mainViewModel.deckList.observe(viewLifecycleOwner) {
            mAdapter.setData(it)
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvDeck.adapter = mAdapter
        binding.rvDeck.layoutManager = LinearLayoutManager(requireContext())
    }

}