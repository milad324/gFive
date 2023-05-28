package com.example.gfive.viewModels.play

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.util.TimeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.pow

@HiltViewModel
class PlayViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val allCardCanShow =
        repository.local.cardsNeedToVisit().asLiveData()

    fun setAnswer(cardEntity: CardEntity, status: Boolean) {
        cardEntity.totalVisit++
        if (status) {
            val nextDayVisit = 2.toDouble().pow(cardEntity.state.toDouble())
            cardEntity.visitTime = TimeManager.getTimeWithAddDays(nextDayVisit.toInt())
            cardEntity.state++

        } else {
            cardEntity.state = 1
            cardEntity.visitTime = TimeManager.getTimeWithAddDays(1)
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.updateCard(cardEntity)
        }

    }
}