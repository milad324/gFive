package com.example.gfive.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.CardVisitEntity
import com.example.gfive.data.database.entities.DeckCardStatus
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


    @Query("SELECT * FROM tbl_group  where id == :id")
    fun getCardByDeckId(id: Int): Flow<DeckCards>

    @Query("SELECT * FROM tbl_card where visitTime<= :currentTime order by visitTime desc")
    fun cardsNeedToVisit(currentTime: Long): Flow<List<CardEntity>>

    @Update
    suspend fun updateCard(cardEntity: CardEntity)

    @Query("SELECT COUNT(id) FROM tbl_card where visitTime<= :currentTime")
    fun countCardsNeedToVisit(currentTime: Long): Flow<Int>

    @Query("SELECT COUNT(id) FROM tbl_group")
    fun countDeck(): Flow<Int>

    @Query("SELECT COUNT(id) FROM tbl_card")
    fun countCard(): Flow<Int>

    @Query("SELECT (SELECT COUNT(*) FROM tbl_card where totalVisit== 0 and deck_Id==:id ) as Unseen,(SELECT COUNT(*) FROM tbl_card where state== 1 and deck_Id==:id and totalVisit!=0 ) as first, (SELECT COUNT(*) FROM tbl_card where state== 2 and deck_Id==:id ) as second,(SELECT COUNT(*) FROM tbl_card where state== 3 and deck_Id==:id ) as third,(SELECT COUNT(*) FROM tbl_card where state== 3 and deck_Id==:id ) as permanent")
    fun deckCardStatus(id: Int): Flow<DeckCardStatus>

    @Insert
    fun createCardVisit(cardVisitEntity: CardVisitEntity)


}