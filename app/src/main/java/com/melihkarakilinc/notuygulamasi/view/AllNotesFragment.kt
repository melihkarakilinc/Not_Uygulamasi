package com.melihkarakilinc.notuygulamasi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.ViewModel.NoteViewModel
import com.melihkarakilinc.notuygulamasi.adapter.NoteAdapter
import kotlinx.android.synthetic.main.fragment_all_notes.*
import kotlinx.android.synthetic.main.fragment_all_notes.view.*

class AllNotesFragment : Fragment() {
    private val noteViewModel: NoteViewModel by viewModels()
    private val adapter: NoteAdapter by lazy { NoteAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_notes, container, false)

        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        noteViewModel.getAllData.observe(viewLifecycleOwner, Observer { data ->
            if (data.isNotEmpty()) {
                card_uyari.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                adapter.setData(data)
            } else {
                recyclerView.visibility = View.GONE
                card_uyari.visibility = View.VISIBLE
            }

        })
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_allNotesFragment_to_insertNoteFragment)
        }
        return view
    }
}