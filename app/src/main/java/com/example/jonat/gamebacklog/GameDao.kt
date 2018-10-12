package com.example.jonat.gamebacklog

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface GameDao {
    @Query("SELECT * from game_table")
    fun getAllGames(): LiveData<List<Game>>

    @Insert(onConflict = REPLACE)
    fun insert(game_table: Game)

    @Query("DELETE from game_table")
    fun deleteAll()
}
