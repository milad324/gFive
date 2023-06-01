package com.example.gfive.ui.fragments.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.gfive.R
import com.example.gfive.databinding.FragmentOverviewBinding
import com.example.gfive.databinding.FragmentPlayBinding
import com.example.gfive.viewModels.MainViewModel
import com.example.gfive.viewModels.play.PlayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OverviewFragment : Fragment(), MenuProvider {

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
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }



    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.overview_menu,menu)
    }
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId){
            R.id.create_backup->{
                this.context?.let { viewModel.backupDatabase(it) }
            }
            R.id.restore_database->{
                this.context?.let { viewModel.restoreDatabase(it) }
            }
        }
        return false
    }

}