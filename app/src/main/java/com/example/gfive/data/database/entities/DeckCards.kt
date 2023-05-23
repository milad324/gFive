package com.example.gfive.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation


data class DeckCards(
    @Embedded val deckEntity: DeckEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "deck_Id"
    )
    val cards: List<CardEntity>
)