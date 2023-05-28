package com.example.gfive.viewModels.card

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckCards
import com.example.gfive.util.TimeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject


@HiltViewModel
class CardViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var cards = MutableLiveData<DeckCards>()
    fun getCardsByDeckId(id: Int) {
        cards = repository.local.getCardByDeckName(id).asLiveData() as MutableLiveData<DeckCards>
    }
    suspend fun createCard(question: String, answer: String, deckId: Int): Boolean {
        viewModelScope.let {
            return if (question.isNotEmpty() && answer.isNotEmpty()) {
                val card = CardEntity(
                    id = 0,
                    question = question,
                    answer = answer,
                    state = 1,
                    deck_Id = deckId,
                    visitTime = TimeManager.getTimeWithAddDays(1),
                    totalVisit = 0
                )
                repository.local.insertCard(card)
                true
            } else {
                false
            }
        }
    }

    fun deleteCard(cardEntity: CardEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteCard(cardEntity)
        }
    }

}