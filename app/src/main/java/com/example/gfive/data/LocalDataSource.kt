package com.example.gfive.data

import androidx.room.Query
import com.example.gfive.data.database.dao.GFiveDao
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckCards
import com.example.gfive.data.database.entities.DeckEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val gFiveDao: GFiveDao) {
    suspend fun insertDeck(deckEntity: DeckEntity) {
        gFiveDao.createGroup(deckEntity)
    }

    fun getAllDecks(): Flow<List<DeckEntity>> {
        return gFiveDao.getAllDecks()
    }

    fun getCardByDeckName(id: Int): Flow<DeckCards> {
        return gFiveDao.getCardByDeckId(id)
    }

    suspend fun insertCard(cardEntity: CardEntity) {
        return gFiveDao.createCard(cardEntity)
    }

    suspend fun deleteCard(cardEntity: CardEntity) {
        return gFiveDao.deleteCard(cardEntity)
    }

    suspend fun deleteDeck(deckEntity: DeckEntity) {
        return gFiveDao.deleteGroup(deckEntity)
    }

    suspend fun editDeck(deckEntity: DeckEntity) {
        return gFiveDao.updateGroup(deckEntity)
    }

    fun cardsNeedToVisit(): Flow<List<CardEntity>> {
        return gFiveDao.cardsNeedToVisit(System.currentTimeMillis())
    }

    suspend fun updateCard(cardEntity: CardEntity) {
        return gFiveDao.updateCard(cardEntity)
    }

    fun countCardsNeedToVisit(): Flow<Int> {
        return gFiveDao.countCardsNeedToVisit(System.currentTimeMillis())
    }

    fun countDeck(): Flow<Int> {
        return gFiveDao.countDeck()
    }

    fun countCard(): Flow<Int> {
        return gFiveDao.countCard()
    }

}