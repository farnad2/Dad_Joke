package com.hoverdroids.noteswitharchitecturecomponents.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.farnadsoft.dadjoke.R
import com.farnadsoft.dadjoke.database.JokeEntity
import com.farnadsoft.dadjoke.ui.JokeDiffCallback
import com.farnadsoft.dadjoke.ui.JokeViewHolder
import com.farnadsoft.dadjoke.ui.OnItemClickListener

class JokeAdapter(): ListAdapter<JokeEntity, JokeViewHolder>(JokeDiffCallback()) {

    var onItemClickListener: OnItemClickListener? = null

    fun getItemAt(position: Int): JokeEntity {
        return getItem(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return JokeViewHolder(this, view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = getItem(position)
        holder.txt_id.text = joke.id
        holder.txt_joke.text = joke.joke
        holder.txt_status.text = joke.status.toString()
    }
}