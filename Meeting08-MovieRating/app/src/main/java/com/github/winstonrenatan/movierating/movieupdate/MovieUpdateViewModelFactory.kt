package com.github.winstonrenatan.movierating.movieupdate

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.winstonrenatan.movierating.database.MovieDatabaseDao

class MovieUpdateViewModelFactory (
    private val dataSource: MovieDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override  fun <T : ViewModel?> create (modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieUpdateViewModel::class.java)) {
            return MovieUpdateViewModel(dataSource, application) as T
        }
        throw IllegalAccessException("ViewModel class not recognized.")
    }

}