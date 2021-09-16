package com.farnadsoft.dadjoke.ui

import androidx.recyclerview.widget.DiffUtil
import com.farnadsoft.dadjoke.database.JokeEntity

class JokeDiffCallback: DiffUtil.ItemCallback<JokeEntity>() {

    override fun areItemsTheSame(oldItem: JokeEntity, newItem: JokeEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: JokeEntity, newItem: JokeEntity): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.joke == newItem.joke &&
                oldItem.status == oldItem.status
    }
}