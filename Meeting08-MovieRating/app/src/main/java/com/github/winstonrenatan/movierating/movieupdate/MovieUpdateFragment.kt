package com.github.winstonrenatan.movierating.movieupdate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.winstonrenatan.movierating.R
import com.github.winstonrenatan.movierating.database.MovieDatabase
import com.github.winstonrenatan.movierating.databinding.FragmentMovieUpdateBinding


class MovieUpdateFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieUpdateBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_update, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = MovieDatabase.getInstance(application).movieDatabaseDao

        val viewModelFactory = MovieUpdateViewModelFactory(dataSource, application)
        val movieUpdateViewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(MovieUpdateViewModel::class.java)

        movieUpdateViewModel.navigateToMovieTracker.observe(this, Observer {
            status -> status?.let {
                when (status) {
                    "clear" -> {
                        this.findNavController().navigate(
                            MovieUpdateFragmentDirections
                                .actionMovieUpdateFragmentToMovieTrackerFragment())
                        movieUpdateViewModel.doneNavigating()
                    }
                    "emptyKey" -> Toast.makeText(this.context, "Please enter the movie key!", Toast.LENGTH_SHORT).show()
                    "emptyMovieName" -> Toast.makeText(this.context, "Please enter a title!", Toast.LENGTH_SHORT).show()
                    "emptyRating" -> Toast.makeText(this.context, "Please rate the movie first!", Toast.LENGTH_SHORT).show()
                    "movieNotFound" -> Toast.makeText(this.context, "There is no movie with that key!", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.setLifecycleOwner(this)
        binding.movieUpdateViewModel = movieUpdateViewModel

        // Inflate the layout for this fragment
        return binding.root
    }

}