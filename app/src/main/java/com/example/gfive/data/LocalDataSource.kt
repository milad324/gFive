package com.example.gfive.data

import com.example.gfive.data.database.dao.GFiveDao
import com.example.gfive.data.database.entities.DeckEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val gFiveDao: GFiveDao) {
    suspend fun insertDeck(deckEntity: DeckEntity){
        gFiveDao.createGroup(deckEntity)
    }

}