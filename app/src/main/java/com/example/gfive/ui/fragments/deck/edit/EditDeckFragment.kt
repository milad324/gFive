package com.example.gfive.ui.fragments.deck.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gfive.R
import com.example.gfive.databinding.DialogAddDeckBinding
import com.example.gfive.databinding.FragmentEditDeckBinding
import com.example.gfive.viewModels.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EditDeckFragment : BottomSheetDialogFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentEditDeckBinding
    private val args by navArgs<EditDeckFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditDeckBinding.inflate(layoutInflater, container, false)
        binding.deckEntity = args.deck
        var editDeck = args.deck
        binding.btnEditDeck.setOnClickListener {
            editDeck.deckName = binding.txtEditDeckName.text.toString()
            mainViewModel.editDeck(editDeck)
            findNavController().navigateUp()
        }
        return binding.root
    }


}