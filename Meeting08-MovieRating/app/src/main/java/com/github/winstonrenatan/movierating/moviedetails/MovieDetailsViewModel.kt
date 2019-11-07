package com.github.winstonrenatan.movierating.moviedetails

import android.widget.EditText
import android.widget.RatingBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.winstonrenatan.movierating.database.Movie
import com.github.winstonrenatan.movierating.database.MovieDatabaseDao
import kotlinx.coroutines.*

class MovieDetailsViewModel (
    private val movieKey: Long = 0L,
    val database: MovieDatabaseDao) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMovieTracker = MutableLiveData<String?>()
    val navigateToMovieTracker: LiveData<String?>
        get() = _navigateToMovieTracker

    fun doneNavigating() {
        _navigateToMovieTracker.value = null
    }

    fun onSubmitMovie (movieName: EditText, rating: RatingBar) {
        when {
            movieName.text.toString() == "" -> _navigateToMovieTracker.value = "emptyMovieName"
            rating.rating.toInt() == 0 -> _navigateToMovieTracker.value = "emptyRating"
            else -> {
                uiScope.launch {
                    withContext(Dispatchers.IO) {
                        val newMovie = Movie()
                        newMovie.movieName = movieName.text.toString()
                        newMovie.rating = rating.rating.toInt()
                        database.insert(newMovie)
                    }
                    _navigateToMovieTracker.value = "clear"
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}