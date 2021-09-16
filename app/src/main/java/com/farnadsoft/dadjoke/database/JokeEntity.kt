package com.farnadsoft.dadjoke.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_jokes")
data class JokeEntity (
    @PrimaryKey var id: String,
    var joke: String?,
    var status: Int?
        )

