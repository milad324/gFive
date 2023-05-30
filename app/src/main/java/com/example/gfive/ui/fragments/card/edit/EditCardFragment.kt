package com.example.gfive.ui.fragments.card.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gfive.R
import com.example.gfive.databinding.FragmentEditCardBinding
import com.example.gfive.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EditCardFragment : Fragment() {
    private lateinit var binding: FragmentEditCardBinding
    private val args by navArgs<EditCardFragmentArgs>()
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditCardBinding.inflate(layoutInflater, container, false)
        binding.card = args.card
        binding.btnEditCard.setOnClickListener {
            var editCard = args.card
            var question = binding.editTxtCardQuestion.text.toString()
            var answer = binding.editTxtCardAnswer.text.toString()
            if (question.isNotEmpty() && answer.isNotEmpty()) {
                editCard.answer = answer
                editCard.question = question
                mainViewModel.editCard(editCard)
                findNavController().navigateUp()
            }
        }
        return binding.root
    }
}