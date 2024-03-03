package com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.Movie
import com.sermedkerim.blutvrecyclerviewhomework6.databinding.MovieCardDesignBinding

class MovieAdapter(var movieList:List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieCardViewHolder>(){
    inner class MovieCardViewHolder(var binding: MovieCardDesignBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardViewHolder {
        val binding = MovieCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) {
        val movie = movieList.get(position)

        holder.binding.imageViewMoviePoster.setImageResource(
            holder.binding.imageViewMoviePoster.context.resources.getIdentifier(
                movie.movie_img,
                "drawable",
                holder.binding.imageViewMoviePoster.context.packageName
            )
        )
        if(movie.is_new){
            holder.binding.textViewisNewMovie.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}