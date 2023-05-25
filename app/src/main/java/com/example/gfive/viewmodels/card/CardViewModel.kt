package com.example.gfive.viewmodels.card

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckCards
import com.example.gfive.data.database.entities.DeckEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CardViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var cards = MutableLiveData<DeckCards>()
    fun getCardsByDeckId(id: Int) {
        cards = repository.local.getCardByDeckName(id).asLiveData() as MutableLiveData<DeckCards>
    }

}