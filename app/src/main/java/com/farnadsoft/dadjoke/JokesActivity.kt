package com.farnadsoft.dadjoke

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.farnadsoft.dadjoke.database.JokeDatabase
import com.hoverdroids.noteswitharchitecturecomponents.ui.JokeAdapter
import com.farnadsoft.dadjoke.ui.NoteItemTouchHandler
import kotlinx.android.synthetic.main.activity_jokes.*

class JokesActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

         mainViewModel = ViewModelProvider(
            this, MainViewModelFactory(
                Repository(
                    ApiService.create(),
                    JokeDatabase.getInstance(applicationContext)!!.jokeDao()
                )
            )
        )
            .get(MainViewModel::class.java)

        jokes_list.layoutManager = LinearLayoutManager(this)

        val adapter = JokeAdapter()
        jokes_list.adapter=adapter

        mainViewModel.getJokesFromDB().observe(this, Observer{ jokes ->
            jokes?.let { adapter.submitList(jokes) }
        })

        ItemTouchHelper(NoteItemTouchHandler(mainViewModel, adapter)).attachToRecyclerView(jokes_list)


    }

}