package com.example.jonat.gamebacklog

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE


@Dao
interface GameDao {

    @Query("SELECT * from game_table")
    fun getAllGames(): LiveData<List<Game>>

    @Update
    fun update(game: Game)

    @Insert (onConflict = REPLACE)
    fun insert(game: Game)

    @Query("DELETE from game_table")
    fun deleteAll()

    @Delete
    fun delete(game: Game)
}