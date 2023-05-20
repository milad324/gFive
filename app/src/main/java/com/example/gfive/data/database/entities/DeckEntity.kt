package com.example.gfive.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_group")
data class DeckEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val deckName: String,
    val createDate: Long = System.currentTimeMillis(),
)