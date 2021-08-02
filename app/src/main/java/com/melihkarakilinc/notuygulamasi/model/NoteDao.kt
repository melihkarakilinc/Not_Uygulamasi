package com.melihkarakilinc.notuygulamasi.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT*FROM note_table ORDER BY id DESC")
    fun getAllData(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(exampleData: Notes)

    @Update
    suspend fun updateData(note: Notes)
}