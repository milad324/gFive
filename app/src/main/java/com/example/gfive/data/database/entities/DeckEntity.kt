package com.example.gfive.data.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gfive.util.Constants.Companion.TABLE_DECK
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = TABLE_DECK)
data class DeckEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var deckName: String,
    val createDate: Long = System.currentTimeMillis(),
): Parcelable