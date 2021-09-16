package com.farnadsoft.dadjoke.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.farnadsoft.dadjoke.R
import com.hoverdroids.noteswitharchitecturecomponents.ui.JokeAdapter

class JokeViewHolder(var jokeAdapter: JokeAdapter, view: View, var onItemClickListener: OnItemClickListener? = null): RecyclerView.ViewHolder(view) {

    var txt_id: TextView = view.findViewById(R.id.txt_id)
    var txt_joke: TextView = view.findViewById(R.id.txt_joke)
    var txt_status: TextView = view.findViewById(R.id.txt_status)

    init {
        view.setOnClickListener(View.OnClickListener {
            if(adapterPosition != NO_POSITION) {
                onItemClickListener?.onItemClick(jokeAdapter.getItemAt(adapterPosition))
            }
        })
    }
}