package com.sermedkerim.blutvrecyclerviewhomework6.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.sermedkerim.blutvrecyclerviewhomework6.R
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.Movie
import com.sermedkerim.blutvrecyclerviewhomework6.data.entity.MovieType
import com.sermedkerim.blutvrecyclerviewhomework6.databinding.FragmentMoviesBinding
import com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter.MovieAdapter
import com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter.MovieTypeAdapter

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater,container,false)

        //Film türleri
        binding.recyclerViewMovieType.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val movieTypes = getMovieTypes()

        val movieTypeAdapter = MovieTypeAdapter(movieTypes)
        binding.recyclerViewMovieType.adapter = movieTypeAdapter

        //Yabancı filmler
        binding.RecyclerViewMostWatchedForeignMovies.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val movies = getMostWatchedForeignMovies()

        val movieAdapter = MovieAdapter(movies)
        binding.RecyclerViewMostWatchedForeignMovies.adapter = movieAdapter

        //Yerli filmler
        binding.RecycleViewMostWatchedTurkishMovies.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val moviesYerli = getMostWatchedTurkishMovies()
        val movieYerliAdapter = MovieAdapter(moviesYerli)

        binding.RecycleViewMostWatchedTurkishMovies.adapter = movieYerliAdapter

        return binding.root
    }

    fun getMovieTypes() : ArrayList<MovieType>{
        val mvtype1 = MovieType(1,"Aile","#c004e4")
        val mvtype2 = MovieType(2,"Aksiyon & Macera","#40ac8c")
        val mvtype3 = MovieType(3,"Aksiyon - Macera","#284cc4")
        val mvtype4 = MovieType(4,"Animasyon","#6804ec")
        val mvtype5 = MovieType(5,"Bilim & Teknoloji","#088c7c")

        val movieTypes = ArrayList<MovieType>()

        movieTypes.add(mvtype1)
        movieTypes.add(mvtype2)
        movieTypes.add(mvtype3)
        movieTypes.add(mvtype4)
        movieTypes.add(mvtype5)

        return movieTypes
    }

    fun getMostWatchedForeignMovies(): ArrayList<Movie>{
        val mv1 = Movie(1,null,"harrypotter1",true)
        val mv2 = Movie(2,null,"harrypotter2",true)
        val mv3 = Movie(3,null,"harrypotter3",true)
        val mv4 = Movie(4,null,"harrypotter4",true)
        val mv5 = Movie(5,null,"harrypotter5",true)

        val movies = ArrayList<Movie>()

        movies.add(mv1)
        movies.add(mv2)
        movies.add(mv3)
        movies.add(mv4)
        movies.add(mv5)

        return movies
    }

    fun getMostWatchedTurkishMovies(): ArrayList<Movie>{
        val mv1 = Movie(6,null,"karveayi",false)
        val mv2 = Movie(7,null,"sifirbir",false)
        val mv3 = Movie(8,null,"munasaka",false)
        val mv4 = Movie(9,null,"thelastschinitzel",false)
        val mv5 = Movie(10,null,"benimvaroshikayem",false)

        val movies = ArrayList<Movie>()

        movies.add(mv1)
        movies.add(mv2)
        movies.add(mv3)
        movies.add(mv4)
        movies.add(mv5)

        return movies
    }
}