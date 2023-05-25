package com.example.gfive.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.databinding.FragmentCardRowItemBinding
import com.example.gfive.util.ListDiffUtil

class CardAdapter : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

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
    }

    fun setData(newCards: List<CardEntity>) {
        val ingredientsDiffUtil =
            ListDiffUtil(cards, newCards)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        cards = newCards
        diffUtilResult.dispatchUpdatesTo(this)
    }
}