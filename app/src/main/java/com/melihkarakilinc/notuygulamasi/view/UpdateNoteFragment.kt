package com.melihkarakilinc.notuygulamasi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.helper.SnackBarHelper
import com.melihkarakilinc.notuygulamasi.ViewModel.NoteViewModel
import com.melihkarakilinc.notuygulamasi.model.Notes
import kotlinx.android.synthetic.main.fragment_update_note.*
import kotlinx.android.synthetic.main.fragment_update_note.view.*


class UpdateNoteFragment : Fragment() {

    private val args: UpdateNoteFragmentArgs by navArgs()
    private lateinit var currentNote: Notes
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentNote = args.note!!
        view.title_et_update.setText(currentNote.baslik)
        view.description_et_update.setText(currentNote.icerik)
        view.add_update.setOnClickListener {
            update(view)
        }

        view.btn_sil_update.setOnClickListener {
            delete(view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_note, container, false)
    }

    fun update(view: View) {
        val title = title_et_update.text.toString().trim()
        val body = description_et_update.text.toString().trim()

        if (title.isNotEmpty()) {
            val note = Notes(currentNote.id, title, body)
            noteViewModel.updateData(note,view)
        } else {
            SnackBarHelper(view,"Lütfen Alanları Doldurunuz!")
        }
    }

    fun delete(view: View){
        val title = title_et_update.text.toString().trim()
        val body = description_et_update.text.toString().trim()
        val note = Notes(currentNote.id, title, body)
        noteViewModel.deleteData(note,view)
    }
}