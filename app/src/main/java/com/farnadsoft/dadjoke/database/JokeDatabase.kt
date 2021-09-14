package com.farnadsoft.dadjoke.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [JokeEntity::class], version = 1)
//abstract class JokeDatabase : RoomDatabase(){
//    abstract  fun jokeDao(): JokeDao
//}


@Database(entities = [JokeEntity::class], exportSchema = false, version = 1)
abstract class JokeDatabase : RoomDatabase() {

     companion object {
                private var jokeDatabase: JokeDatabase? = null
        fun getInstance(context: Context?): JokeDatabase? {
            if (jokeDatabase == null) {
                jokeDatabase =
                    Room.databaseBuilder(context!!, JokeDatabase::class.java, "db_jokes")
                        .allowMainThreadQueries().build()
            }
            return jokeDatabase
        }
    }

    abstract fun jokeDao(): JokeDao

}