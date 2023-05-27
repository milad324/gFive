package com.example.gfive.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.gfive.util.Constants.Companion.TABLE_CARD
import java.time.Instant


@Entity(
    tableName = TABLE_CARD,
    foreignKeys = [ForeignKey(
        entity = DeckEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("deck_Id"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var createDate: Long = System.currentTimeMillis(),
    var question: String,
    var answer: String,
    var state: Short,
    var visitTime: Long,
    @ColumnInfo(index = true)
    var deck_Id: Int
)
