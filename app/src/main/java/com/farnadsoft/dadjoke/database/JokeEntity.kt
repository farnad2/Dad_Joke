package com.farnadsoft.dadjoke.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_jokes")
data class JokeEntity (
    @PrimaryKey val id: String,
    //val id: String,
    val joke: String?,
    val status: Int?
        )

