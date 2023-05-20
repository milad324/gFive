package com.example.gfive.ui.data

import com.example.gfive.ui.data.database.dao.GFiveDao
import com.example.gfive.ui.data.database.entities.DeckEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val gFiveDao: GFiveDao) {
    suspend fun insertDeck(deckEntity: DeckEntity){
        gFiveDao.createGroup(deckEntity)
    }

}