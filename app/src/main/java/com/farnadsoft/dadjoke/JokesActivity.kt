package com.farnadsoft.dadjoke

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.farnadsoft.dadjoke.databinding.ActivityJokesBinding
import kotlinx.android.synthetic.main.activity_jokes.*
import java.util.ArrayList

class JokesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

        jokes_list.layoutManager = LinearLayoutManager(this)

        val jokes=ArrayList<JokeData>()
        jokes.add(JokeData("1","sample joke one",100))
        jokes.add(JokeData("2","sample joke two",200))
        jokes.add(JokeData("3","sample joke three",300))


        val adapter=JokeRecyclerAdapter(jokes)
        jokes_list.adapter=adapter


    }

}