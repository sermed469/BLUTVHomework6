package com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.MovieType
import com.sermedkerim.blutvrecyclerviewhomework6.databinding.MovieTypeCardDesignBinding

class MovieTypeAdapter(var moviTypeList:List<MovieType>) : RecyclerView.Adapter<MovieTypeAdapter.MovieTypeCardViewHolder>() {
    inner class MovieTypeCardViewHolder(var binding: MovieTypeCardDesignBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTypeCardViewHolder {
        val binding: MovieTypeCardDesignBinding = MovieTypeCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieTypeCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieTypeCardViewHolder, position: Int) {
        val movieType = moviTypeList.get(position)

        holder.binding.textViewCardMovieType.text = movieType.movie_type_name
        holder.binding.movieTypeCardView.backgroundTintList = ColorStateList.valueOf(Color.parseColor(movieType.movie_type_background))
    }

    override fun getItemCount(): Int {
        return moviTypeList.size
    }
}