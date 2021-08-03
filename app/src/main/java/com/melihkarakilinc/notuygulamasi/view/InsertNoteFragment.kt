package com.melihkarakilinc.notuygulamasi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.helper.SnackBarHelper
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
            insertNote(view)
        }
        return view
    }

    private fun insertNote(view: View) {
        val title = title_et.text.toString()
        val description = description_et.text.toString()
        if (verifyData(title, description)) {
            val newData = Notes(
                0,
                title,
                description
            )
            noteViewModel.insertData(newData,view)
        } else {
            SnackBarHelper(view,getString(R.string.bos_alan))
        }
    }

    private fun verifyData(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }

}