package com.example.gfive.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gfive.R
import com.example.gfive.databinding.FragmentOverviewBinding
import com.example.gfive.databinding.FragmentPlayBinding
import com.example.gfive.viewModels.MainViewModel
import com.example.gfive.viewModels.play.PlayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentOverviewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOverviewBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.btnLetsStart.setOnClickListener {
            findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToPlayFragment())
        }
        return binding.root
    }
}