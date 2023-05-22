package com.example.gfive.viewmodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.DeckEntity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository, application: Application
) : AndroidViewModel(application) {
    val deckName = MutableLiveData<String>()
    val deckList =repository.local.getAllDecks().asLiveData()


    fun createDeck() {
        if (deckName.value != null) {
            val deckEntity = DeckEntity(0, deckName = deckName.value!!)
            viewModelScope.launch(Dispatchers.IO) {
                repository.local.insertDeck(deckEntity)
            }
            Toast.makeText(getApplication(), "deck ${deckName.value} added", Toast.LENGTH_SHORT)
                .show()

        } else {
            Toast.makeText(getApplication(), "deck name cant be empty", Toast.LENGTH_SHORT)
                .show()
        }

    }


}