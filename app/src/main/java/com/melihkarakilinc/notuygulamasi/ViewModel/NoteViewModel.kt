package com.melihkarakilinc.notuygulamasi.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bersyte.noteapp.repository.NoteRepository
import com.melihkarakilinc.notuygulamasi.model.AppDatabase
import com.melihkarakilinc.notuygulamasi.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteDao = AppDatabase.getDatabase(application).NoteDao()
    private val repository: NoteRepository

    val getAllData: LiveData<List<Notes>>

    init {
        repository = NoteRepository(noteDao)
        getAllData = repository.getAllData
    }

    fun insertData(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(notes)
        }
    }

    fun updateData(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(notes)
        }
    }
}