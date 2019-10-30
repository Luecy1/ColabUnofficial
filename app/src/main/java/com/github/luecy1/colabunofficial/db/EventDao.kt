package com.github.luecy1.colabunofficial.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.luecy1.colabunofficial.db.model.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM Event")
    fun getEvent(): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: Event)

}