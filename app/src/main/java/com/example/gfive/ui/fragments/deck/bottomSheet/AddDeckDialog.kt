package com.example.gfive.ui.fragments.deck.bottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.gfive.databinding.DialogAddDeckBinding
import com.example.gfive.viewModels.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddDeckDialog : BottomSheetDialogFragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: DialogAddDeckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogAddDeckBinding.inflate(inflater)
        binding.viewModel = mainViewModel


        return binding.root
    }

}