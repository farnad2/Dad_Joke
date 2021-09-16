package com.farnadsoft.dadjoke.ui

import com.farnadsoft.dadjoke.database.JokeEntity


interface OnItemClickListener {
    fun onItemClick(joke: JokeEntity)
}