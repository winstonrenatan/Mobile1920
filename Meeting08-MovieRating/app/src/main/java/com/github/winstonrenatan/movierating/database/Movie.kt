package com.github.winstonrenatan.movierating.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "movie_rating_table")
data class Movie (
    @PrimaryKey (autoGenerate = true)
    var movieId: Long = 0L,

    @ColumnInfo (name = "movie_name")
    var movieName: String = "",

    @ColumnInfo (name = "rating")
    var rating: Int = -1
)