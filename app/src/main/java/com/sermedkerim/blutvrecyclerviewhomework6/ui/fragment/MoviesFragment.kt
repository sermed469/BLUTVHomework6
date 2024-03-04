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
import com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter.MovieListAdapter
import com.sermedkerim.blutvrecyclerviewhomework6.ui.adapter.MovieSeriesAdapter
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

        //Film serileri
        binding.recyclerViewMovieSeries.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val movieSeries = getMovieSeries()
        val movieSeriesAdapter = MovieSeriesAdapter(movieSeries)

        binding.recyclerViewMovieSeries.adapter = movieSeriesAdapter

        //Tüm filmler
        binding.recyclerViewAllMovies.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        val allMovies = getAllMovies(movieTypes)
        val movieListAdapter = MovieListAdapter(movieTypes,allMovies)

        binding.recyclerViewAllMovies.adapter = movieListAdapter

        return binding.root
    }

    fun getMovieTypes() : ArrayList<MovieType>{
        val mvAile = MovieType(1,"Aile","#c004e4")
        val mvAksiyon1 = MovieType(2,"Aksiyon&Macera","#40ac8c")
//        val mvAksiyon = MovieType(3,"Aksiyon-Macera","#284cc4")
//        val mvAnimasyon = MovieType(4,"Animasyon","#6804ec")
//        val mvBilim = MovieType(5,"Bilim & Teknoloji","#088c7c")
        val mvBiyografi = MovieType(6,"Biyografi","#d0046c")
        val mvDram = MovieType(7,"Dram","#089ccc")
        val mvDunyaSinemasi = MovieType(8,"Dünya Sineması","#48a4fc")
        val mvFantastik = MovieType(9,"Fantastik-Bilim Kurgu","#088c7c")
        val mvFestival = MovieType(10,"Festival","#f0047c")
        val mvGizem = MovieType(11,"Gizem","#c004e4")
        val mvKomedi = MovieType(12,"Komedi","#6804ec")
        val mvKorku = MovieType(13,"Korku-Gerilim","#70ac14")
        val mvPolisiye = MovieType(14,"Polisiye-Suç","#284cc4")
        val mvRomantik = MovieType(15,"Romantik","#089ccc")
        val mvTarih = MovieType(7,"Tarih","#088c7c")

        val movieTypes = ArrayList<MovieType>()

        movieTypes.add(mvAile)
        movieTypes.add(mvAksiyon1)
//        movieTypes.add(mvAksiyon)
//        movieTypes.add(mvAnimasyon)
//        movieTypes.add(mvBilim)
        movieTypes.add(mvBiyografi)
        movieTypes.add(mvDram)
        movieTypes.add(mvDunyaSinemasi)
        movieTypes.add(mvFantastik)
        movieTypes.add(mvFestival)
        movieTypes.add(mvGizem)
        movieTypes.add(mvKomedi)
        movieTypes.add(mvKorku)
        movieTypes.add(mvPolisiye)
        movieTypes.add(mvRomantik)
        movieTypes.add(mvTarih)

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

    fun getMovieSeries():ArrayList<Movie>{
        val mv1 = Movie(10,null,"harrypotterseries",false)
        val mv2 = Movie(11,null,"fantasticbeastsseries",false)
        val mv3 = Movie(12,null,"residentevilseries",false)

        val movieSeries = ArrayList<Movie>()

        movieSeries.add(mv1)
        movieSeries.add(mv2)
        movieSeries.add(mv3)

        return movieSeries
    }

    fun getAllMovies(movieTypes:ArrayList<MovieType>):ArrayList<Movie>{
        val mv1 = Movie(13,movieTypes.get(0),"fantasticbeasts",false)
        val mv2 = Movie(14,movieTypes.get(0),"crimesofgrindelwald",false)
        val mv3 = Movie(15,movieTypes.get(0),"shazam6",true)
        val mv4 = Movie(16,movieTypes.get(0),"pikachu",true)

        val mv5 = Movie(17,movieTypes.get(1),"everythingeverywhere",false)
        val mv6 = Movie(18,movieTypes.get(1),"thecolony",false)
        val mv7 = Movie(19,movieTypes.get(1),"sifirbir",false)
        val mv8 = Movie(20,movieTypes.get(1),"bladerunner2049",false)

        val mv9 = Movie(21,movieTypes.get(2),"corsage",false)
        val mv10 = Movie(22,movieTypes.get(2),"donniebrasco",false)
        val mv11 = Movie(23,movieTypes.get(2),"thewalk",false)
        val mv12 = Movie(24,movieTypes.get(2),"thesocialnetwork",false)

        val mv13 = Movie(25,movieTypes.get(3),"karveayi",false)
        val mv14 = Movie(26,movieTypes.get(3),"worstpersonoftheworld",false)
        val mv15 = Movie(27,movieTypes.get(3),"father",false)
        val mv16 = Movie(28,movieTypes.get(3),"parasite",false)

        val mv17 = Movie(29,movieTypes.get(4),"atasteofhunger",false)
        val mv18 = Movie(30,movieTypes.get(4),"thecolony",false)
        val mv19 = Movie(31,movieTypes.get(4),"undine",false)
        val mv20 = Movie(32,movieTypes.get(4),"neworder",false)

        val mv21 = Movie(33,movieTypes.get(5),"everythingeverywhere",false)
        val mv22 = Movie(34,movieTypes.get(5),"palmsprings",false)
        val mv23 = Movie(35,movieTypes.get(5),"thecolony",false)
        val mv24 = Movie(36,movieTypes.get(5),"archive",false)

        val mv25 = Movie(37,movieTypes.get(6),"benimvaroshikayem",false)
        val mv26 = Movie(38,movieTypes.get(6),"zuhal",false)
        val mv27 = Movie(39,movieTypes.get(6),"damatkogusu",false)
        val mv28 = Movie(40,movieTypes.get(6),"iyiyemekoldurur",false)

        val mv29 = Movie(41,movieTypes.get(7),"father",false)
        val mv30 = Movie(42,movieTypes.get(7),"palmsprings",false)
        val mv31 = Movie(43,movieTypes.get(7),"pig",false)
        val mv32= Movie(44,movieTypes.get(7),"undine",false)

        val mv33 = Movie(45,movieTypes.get(8),"shazam6",true)
        val mv34 = Movie(46,movieTypes.get(8),"pikachu",true)
        val mv35 = Movie(47,movieTypes.get(8),"worstpersonoftheworld",false)
        val mv36= Movie(48,movieTypes.get(8),"everythingeverywhere",false)

        val mv37 = Movie(49,movieTypes.get(9),"parasite",false)
        val mv38 = Movie(50,movieTypes.get(9),"spiral",false)
        val mv39 = Movie(51,movieTypes.get(9),"antebellum",false)
        val mv40= Movie(52,movieTypes.get(9),"life",false)

        val mv41 = Movie(53,movieTypes.get(10),"piranhas",false)
        val mv42 = Movie(54,movieTypes.get(10),"babydriver",false)
        val mv43 = Movie(55,movieTypes.get(10),"spiral",false)
        val mv44= Movie(56,movieTypes.get(10),"breakingnews",false)

        val mv45 = Movie(57,movieTypes.get(11),"worstpersonoftheworld",false)
        val mv46 = Movie(58,movieTypes.get(11),"atasteofhunger",false)
        val mv47 = Movie(59,movieTypes.get(11),"bergmanisland",false)
        val mv48= Movie(60,movieTypes.get(11),"rifkinfestival",false)

        val mv49 = Movie(61,movieTypes.get(12),"corsage",false)
        val mv50 = Movie(62,movieTypes.get(12),"naturallight",false)
        val mv51 = Movie(63,movieTypes.get(12),"resistance",false)
        val mv52= Movie(64,movieTypes.get(12),"stefanzweig",false)

        val movieList = ArrayList<Movie>()

        movieList.add(mv1)
        movieList.add(mv2)
        movieList.add(mv3)
        movieList.add(mv4)

        movieList.add(mv5)
        movieList.add(mv6)
        movieList.add(mv7)
        movieList.add(mv8)

        movieList.add(mv9)
        movieList.add(mv10)
        movieList.add(mv11)
        movieList.add(mv12)

        movieList.add(mv13)
        movieList.add(mv14)
        movieList.add(mv15)
        movieList.add(mv16)

        movieList.add(mv17)
        movieList.add(mv18)
        movieList.add(mv19)
        movieList.add(mv20)

        movieList.add(mv21)
        movieList.add(mv22)
        movieList.add(mv23)
        movieList.add(mv24)

        movieList.add(mv25)
        movieList.add(mv26)
        movieList.add(mv27)
        movieList.add(mv28)

        movieList.add(mv29)
        movieList.add(mv30)
        movieList.add(mv31)
        movieList.add(mv32)

        movieList.add(mv33)
        movieList.add(mv34)
        movieList.add(mv35)
        movieList.add(mv36)

        movieList.add(mv37)
        movieList.add(mv38)
        movieList.add(mv39)
        movieList.add(mv40)

        movieList.add(mv41)
        movieList.add(mv42)
        movieList.add(mv43)
        movieList.add(mv44)

        movieList.add(mv45)
        movieList.add(mv46)
        movieList.add(mv47)
        movieList.add(mv48)

        movieList.add(mv49)
        movieList.add(mv50)
        movieList.add(mv51)
        movieList.add(mv52)

        return movieList
    }
}