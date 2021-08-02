package com.melihkarakilinc.notuygulamasi.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melihkarakilinc.notuygulamasi.R
import com.melihkarakilinc.notuygulamasi.model.Notes
import kotlinx.android.synthetic.main.note_item.view.*
import java.util.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    var dataList = emptyList<Notes>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.sTitle.text = dataList[position].baslik
        holder.itemView.sDescription.text = dataList[position].icerik
        val random = Random()
        val color =
            Color.argb(
                255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256)
            )
        holder.itemView.viewColor.setBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(exampleData: List<Notes>) {
        this.dataList = exampleData
        notifyDataSetChanged()
    }

}