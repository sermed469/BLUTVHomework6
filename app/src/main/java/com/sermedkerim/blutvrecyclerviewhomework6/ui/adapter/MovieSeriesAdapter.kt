package com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.Movie
import com.sermedkerim.blutvrecyclerviewhomework6.databinding.MovieSeriesCardDesignBinding

class MovieSeriesAdapter(var movieSeriesList : List<Movie>): RecyclerView.Adapter<MovieSeriesAdapter.MovieSeriesViewHolder>() {
    inner class MovieSeriesViewHolder(var binding: MovieSeriesCardDesignBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSeriesViewHolder {
        val binding = MovieSeriesCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieSeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieSeriesViewHolder, position: Int) {
        val movie = movieSeriesList.get(position)

        holder.binding.imageViewMovieSeries.setImageResource(
            holder.binding.imageViewMovieSeries.context.resources.getIdentifier(
                movie.movie_img,
                "drawable",
                holder.binding.imageViewMovieSeries.context.packageName
            )
        )
    }

    override fun getItemCount(): Int {
        return movieSeriesList.size
    }
}