package com.example.gfive.ui.fragments.play

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gfive.R
import com.example.gfive.databinding.FragmentCardBinding
import com.example.gfive.databinding.FragmentPlayBinding
import com.example.gfive.viewModels.MainViewModel
import com.example.gfive.viewModels.play.PlayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    private val viewModel: PlayViewModel by viewModels()
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlayBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        binding.btnShowAnswer.setOnClickListener {
            binding.txtPlayQuestion.visibility = View.VISIBLE
            it.visibility = View.GONE
            mainViewModel.speaker.speakOut(binding.card!!.answer)
        }
        viewModel.allCardCanShow.observe(viewLifecycleOwner) {
            binding.btnShowAnswer.visibility = View.VISIBLE
            binding.txtPlayQuestion.visibility = View.GONE
            if (it.isNotEmpty()) {
                binding.card = it.first()
                mainViewModel.speaker.speakOut(binding.card!!.question)
            } else {
                findNavController().navigate(PlayFragmentDirections.actionPlayFragmentToDoneFragment())
            }
        }

        binding.viewModel = viewModel

        return binding.root
    }

}
