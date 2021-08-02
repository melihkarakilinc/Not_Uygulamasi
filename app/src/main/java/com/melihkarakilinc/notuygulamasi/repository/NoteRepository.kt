package com.bersyte.noteapp.repository

import androidx.lifecycle.LiveData
import com.melihkarakilinc.notuygulamasi.model.NoteDao
import com.melihkarakilinc.notuygulamasi.model.Notes

class NoteRepository(private val noteDao: NoteDao) {

    val getAllData: LiveData<List<Notes>> = noteDao.getAllData()

    suspend fun insertData(notes: Notes) {
        noteDao.insertData(notes)
    }
}