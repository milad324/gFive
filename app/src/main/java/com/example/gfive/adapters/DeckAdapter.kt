package com.example.gfive.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gfive.data.database.entities.DeckEntity
import com.example.gfive.databinding.DeckRowLayoutBinding
import com.example.gfive.util.ListDiffUtil
import com.example.gfive.viewModels.MainViewModel


class DeckAdapter(private val viewModel: MainViewModel) :
    RecyclerView.Adapter<DeckAdapter.MyViewHolder>() {

    private var deckList = emptyList<DeckEntity>()

    class MyViewHolder(val binding: DeckRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DeckRowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = deckList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.deckEntity = deckList[position]
        holder.binding.deleteDeck.setOnClickListener {
            val builder = AlertDialog.Builder(holder.binding.root.context)
            builder.setMessage("Are you sure you want to Delete?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    // Delete selected card from database
                    viewModel.deleteDeck(deckList[position])
                }
                .setNegativeButton("No") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()
        }
    }

    fun setData(newDecks: List<DeckEntity>) {
        val ingredientsDiffUtil =
            ListDiffUtil(deckList, newDecks)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        deckList = newDecks
        diffUtilResult.dispatchUpdatesTo(this)
    }
}