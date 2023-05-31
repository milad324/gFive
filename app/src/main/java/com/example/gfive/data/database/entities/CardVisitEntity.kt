package com.example.gfive.data.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.gfive.util.Constants
import kotlinx.android.parcel.Parcelize


@Entity(
    tableName = Constants.TABLE_CARD_VISIT,
    foreignKeys = [ForeignKey(
        entity = CardEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("cardId"),
        onDelete = ForeignKey.CASCADE
    )]
)
@Parcelize
data class CardVisitEntity(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(index = true)
    var cardId: Int,
    var visitTime: Long,
    var previousStage: Int,
    var nextStage: Int

) : Parcelable