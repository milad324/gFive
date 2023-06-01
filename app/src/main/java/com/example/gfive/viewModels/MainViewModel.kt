package com.example.gfive.viewModels

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gfive.data.Repository
import com.example.gfive.data.database.entities.CardEntity
import com.example.gfive.data.database.entities.DeckEntity
import com.example.gfive.util.Constants.Companion.DATABASE_NAME
import com.example.gfive.util.TextToSpeech
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.nio.channels.FileChannel
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository, application: Application
) : AndroidViewModel(application) {
    val deckName = MutableLiveData<String>()
    val deckList = repository.local.getAllDecks().asLiveData()
    val todayCardNumber = repository.local.countCardsNeedToVisit().asLiveData()
    val totalCardNumber = repository.local.countCard().asLiveData()
    val totalDeckNumber = repository.local.countDeck().asLiveData()
    val speaker = TextToSpeech(application)
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

    fun deleteDeck(deckEntity: DeckEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.deleteDeck(deckEntity)
        }
    }

    fun editDeck(deckEntity: DeckEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.editDeck(deckEntity)
        }
    }

    fun editCard(card: CardEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.updateCard(card)
        }
    }

    fun readText(text: String) {
        speaker.speakOut(text)
    }

    fun backupDatabase(context: Context) {
        try {
            val backupDir = File(Environment.getExternalStorageDirectory(), "/backup")
           Log.d("milad","123")
            if (backupDir.canWrite()) {

                val currentDBPath = context.getDatabasePath(DATABASE_NAME).absolutePath
                val backupDBPath = "backupname.db"
                val backupDB = File(backupDir, backupDBPath)
                if (backupDB.exists()) {
                    backupDB.delete()
                }
                if (backupDB.createNewFile()) {
                    val src = FileInputStream(currentDBPath).channel
                    val dst = FileOutputStream(backupDB).channel
                    dst.transferFrom(src, 0, src.size())
                    src.close()
                    dst.close()
                }
            }
            Toast.makeText(
                context,
                "Your database backup created at :$backupDir",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Log.d("milad", e.toString())
        }
    }

    fun restoreDatabase(context: Context) {
        try {
            val backupDir = File(Environment.getExternalStorageDirectory(), "/backup")
            if (backupDir.canWrite()) {
                val currentDBPath = context.getDatabasePath(DATABASE_NAME).absolutePath
                val backupDBPath = "backupname.db"
                val backupDB = File(backupDir, backupDBPath)
                if (backupDB.exists()) {
                    val src = FileInputStream(backupDB).channel
                    val dst = FileOutputStream(currentDBPath).channel
                    dst.transferFrom(src, 0, src.size())
                    src.close()
                    dst.close()
                }
            }
            Toast.makeText(
                context,
                "Your database backup was restored",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}