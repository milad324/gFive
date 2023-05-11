package com.example.gfive.util

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.*

class ListDiffUtil<T>( private val oldList: List<T>,
                       private val newList: List<T>): Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize()= newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] === newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldList[oldItemPosition] == newList[newItemPosition]
}