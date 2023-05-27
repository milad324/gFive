package com.example.gfive.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckCards
import com.example.gfive.data.database.entities.DeckEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GFiveDao {
    @Insert
    suspend fun createGroup(groupEntity: DeckEntity)

    @Update
    suspend fun updateGroup(groupEntity: DeckEntity)

    @Delete
    suspend fun deleteGroup(groupEntity: DeckEntity)

    @Query("SELECT * FROM tbl_group")
    fun getAllDecks(): Flow<List<DeckEntity>>

    @Insert
    suspend fun createCard(cardEntity: CardEntity)

    @Delete
    suspend fun deleteCard(cardEntity: CardEntity)

    @Transaction
    @Query("SELECT * FROM tbl_group  where id == :id")
    fun getCardByDeckId(id: Int): Flow<DeckCards>
}