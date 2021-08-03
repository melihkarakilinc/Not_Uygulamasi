package com.melihkarakilinc.notuygulamasi.ViewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.melihkarakilinc.notuygulamasi.repository.NoteRepository
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.helper.SnackBarHelper
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

    fun insertData(notes: Notes,view: View) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(notes)
        }
        SnackBarHelper(view,"Ekleme Başarılı!")
        view.findNavController().navigate(R.id.action_insertNoteFragment_to_allNotesFragment)
    }

    fun updateData(notes: Notes,view :View) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(notes)
        }
        SnackBarHelper(view,"Güncelleme Başarılı")
        view.findNavController().navigate(R.id.action_updateNoteFragment_to_allNotesFragment)
    }

    fun deleteData(notes: Notes,view: View){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData(notes)
        }
        SnackBarHelper(view,"Silme İşlemi Başarılı")
        view.findNavController().navigate(R.id.action_updateNoteFragment_to_allNotesFragment)
    }
}