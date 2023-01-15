package com.example.moviepagapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviepagapp.databinding.MovieCardLayoutBinding
import com.example.moviepagapp.models.Movie

import com.example.moviepagapp.ui.fragment.MainFragmentDirections


class MovieAdapter() : PagingDataAdapter<Movie , MovieAdapter.MyViewHolder>(diffCallback) {

   inner class MyViewHolder(val binding: MovieCardLayoutBinding ): RecyclerView.ViewHolder(binding.root)


    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            movieTitleText.text = "${currentItem?.title}"

            val url = "https://image.tmdb.org/t/p/w500"
            val image_url = currentItem?.poster
            val last_url = "${url}${image_url}"
            movieImageView.load(last_url){
                crossfade(true)
                crossfade(1000)
            }
        }
        holder.binding.card.setOnClickListener{
            val go = currentItem?.let { it1 -> MainFragmentDirections.dGo(movie = it1) }
            if (go != null) {
                Navigation.findNavController(it).navigate(go)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(MovieCardLayoutBinding.inflate
            (LayoutInflater.from(parent.context),
        parent, false
        )
        )
    }
}