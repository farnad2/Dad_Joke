package com.farnadsoft.dadjoke.ui

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.farnadsoft.dadjoke.MainViewModel
import com.hoverdroids.noteswitharchitecturecomponents.ui.JokeAdapter

class NoteItemTouchHandler(private val jokeViewModel: MainViewModel, private val adapter: JokeAdapter) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT + ItemTouchHelper.RIGHT) {

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        jokeViewModel.delete(adapter.getItemAt(viewHolder.adapterPosition))
    }
}