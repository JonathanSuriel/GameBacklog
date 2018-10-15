package com.example.jonat.gamebacklog

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlin.coroutines.experimental.CoroutineContext

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: GameRepository

    val allGames: LiveData<List<Game>>

    init {
        val gameDao = GameDatabase.getDatabase(application, scope).gameDao()
        repository = GameRepository(gameDao)
        allGames = repository.allGames
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(game: Game) = scope.launch(Dispatchers.IO) {
        repository.insert(game)
    }
    fun delete(game: Game) = scope.launch(Dispatchers.IO) {
        repository.delete(game)
    }
    fun updateGame(game: Game) = scope.launch(Dispatchers.IO) {
        repository.updateGame(game)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}