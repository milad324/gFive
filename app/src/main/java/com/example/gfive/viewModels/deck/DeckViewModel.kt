package com.example.gfive.viewModels.deck

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.DeckCardStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DeckViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val deckStatus = MutableLiveData<DeckCardStatus>()
   suspend fun getDeckCardStatus(id: Int) {
        viewModelScope.let {
            repository.local.deckCardStatus(id).collect {
                Log.d("milad",it.toString())
                deckStatus.value = it
                Log.d("milad",it.toString())
            }
        }
    }
}