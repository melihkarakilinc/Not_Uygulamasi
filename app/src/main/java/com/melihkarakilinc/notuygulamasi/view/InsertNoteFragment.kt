package com.melihkarakilinc.notuygulamasi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.ViewModel.NoteViewModel
import com.melihkarakilinc.notuygulamasi.model.Notes
import kotlinx.android.synthetic.main.fragment_insert_note.*
import kotlinx.android.synthetic.main.fragment_insert_note.view.*

class InsertNoteFragment : Fragment() {
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_insert_note, container, false)
        view.add.setOnClickListener {
            insertNote()
        }
        return view
    }

    private fun insertNote() {
        val title = title_et.text.toString()
        val description = description_et.text.toString()
        if (verifyData(title, description)) {
            val newData = Notes(
                0,
                title,
                description
            )
            noteViewModel.insertData(newData)
            view?.let {
                Snackbar.make(
                    it,
                    "Ekleme Başarılı!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            findNavController().navigate(R.id.action_insertNoteFragment_to_allNotesFragment)
        } else {
            view?.let {
                Snackbar.make(
                    it, // Parent view
                    "Lütfen Alanları Boş Bırakmayınız!", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        }
    }

    private fun verifyData(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }

}