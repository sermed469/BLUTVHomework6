package com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.Movie
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.MovieType
import com.sermedkerim.blutvrecyclerviewhomework6.databinding.MovieSeriesListCardDesignBinding

class MovieListAdapter(var movieType:List<MovieType>,var allMovies:List<Movie>): RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {
    inner class MovieListViewHolder(var binding: MovieSeriesListCardDesignBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding = MovieSeriesListCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movieType = movieType.get(position)

        holder.binding.textViewMovieListType.text = movieType.movie_type_name

        holder.binding.recylclerViewMovieListByType.layoutManager =
            LinearLayoutManager(
                holder.binding.recylclerViewMovieListByType.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        //Türe göre filtreleme

        val filteredMovies = allMovies.filter {
            it.movie_type!!.movie_type_name == movieType.movie_type_name
        }
        Log.e("movie",movieType.movie_type_name)
        for (m in filteredMovies){
            Log.e("movie",m.movie_img)
        }
        val movieAdapter = MovieAdapter(filteredMovies)
        holder.binding.recylclerViewMovieListByType.adapter = movieAdapter
    }

    override fun getItemCount(): Int {
        return movieType.size
    }

}