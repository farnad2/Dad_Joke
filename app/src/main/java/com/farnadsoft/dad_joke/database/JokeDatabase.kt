package com.farnadsoft.dadjoke0.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JokeEntity::class], version = 1)
abstract class JokeDatabase : RoomDatabase(){
    abstract  fun jokeDao(): JokeDao
}


