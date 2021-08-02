package com.melihkarakilinc.notuygulamasi.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("SELECT*FROM note_table ORDER BY id DESC")
    fun getAllData():LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(exampleData: Notes)
}