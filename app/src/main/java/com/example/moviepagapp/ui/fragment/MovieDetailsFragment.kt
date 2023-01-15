package com.example.moviepagapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.moviepagapp.R
import com.example.moviepagapp.databinding.FragmentMovieDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

        private lateinit var binding: FragmentMovieDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding =FragmentMovieDetailsBinding.inflate(inflater, container, false)


        val bundle : MovieDetailsFragmentArgs by navArgs()
        val getMovie = bundle.movie
        val url = "https://image.tmdb.org/t/p/w500"
        val image_url = getMovie.poster
        val last_url = "${url}${image_url}"
        Picasso.get().load(last_url).into(binding.DetailsImage)
        binding.toolbar2.title = getMovie.title
        binding.DetailsTitleTextView.text=getMovie.title
        binding.detailsDateTextview.text=getMovie.release
        binding.rateTextView.text=getMovie.voteAverage.toString()
        binding.descTextView.text=getMovie.descirpiton

        return binding.root



    }


}