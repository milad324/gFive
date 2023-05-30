package com.example.gfive.ui.fragments.card.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gfive.databinding.FragmentAddCardBinding
import com.example.gfive.viewModels.card.CardViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AddCardFragment : BottomSheetDialogFragment() {

    private val args by navArgs<AddCardFragmentArgs>()
    private lateinit var binding: FragmentAddCardBinding
    private val viewModel: CardViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCardBinding.inflate(layoutInflater, container, false)
        binding.deck = args.deck
        binding.btnAddCard.setOnClickListener {

            lifecycleScope.launch{
                if (viewModel.createCard(
                        binding.editTxtCardQuestion.text.toString(),
                        binding.editTxtCardAnswer.text.toString(),
                        args.deck.id
                    )
                ) {
                    findNavController().navigate(
                        AddCardFragmentDirections.actionAddCardFragmentToCardFragment(
                            args.deck
                        )
                    )
                } else {
                    Toast.makeText(context, "question or answer can't be empty", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        return binding.root
    }

}
