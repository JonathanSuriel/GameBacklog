package com.example.jonat.gamebacklog

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

    class GameRepository(private val gameDao: GameDao) {

        val allGames: LiveData<List<Game>> = gameDao.getAllGames()

        @WorkerThread
        suspend fun insert(game: Game) {
            gameDao.insert(game)
        }

        @WorkerThread
        fun delete(game:Game){
            gameDao.delete(game)
        }

        @WorkerThread
        fun updateGame(game:Game){
            gameDao.update(game)
        }
    }
