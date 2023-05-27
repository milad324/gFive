package com.example.gfive.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.databinding.FragmentCardRowItemBinding
import com.example.gfive.util.ListDiffUtil
import com.example.gfive.viewModels.card.CardViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class CardAdapter(private val viewModel: CardViewModel) :
    RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    private var cards = emptyList<CardEntity>()

    class MyViewHolder(val binding: FragmentCardRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FragmentCardRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.card = cards[position]
        holder.binding.btnDeleteCard.setOnClickListener {

            val builder = AlertDialog.Builder(holder.binding.root.context)
            builder.setMessage("Are you sure you want to Delete?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    // Delete selected card from database
                    viewModel.deleteCard(cards[position])
                }
                .setNegativeButton("No") { dialog, id ->
                    // Dismiss the dialog
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()


        }
    }

    fun setData(newCards: List<CardEntity>) {
        val ingredientsDiffUtil =
            ListDiffUtil(cards, newCards)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        cards = newCards
        diffUtilResult.dispatchUpdatesTo(this)
    }
}