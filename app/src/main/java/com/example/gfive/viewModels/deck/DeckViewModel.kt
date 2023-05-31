package com.example.gfive.viewModels.deck

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.DeckCardStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DeckViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var deckStatus = MutableLiveData<DeckCardStatus>()
    fun getDeckCardStatus(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deckStatus = repository.local.deckCardStatus(id).asLiveData() as MutableLiveData<DeckCardStatus>
        }
    }
}