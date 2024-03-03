package com.sermedkerim.blutvrecyclerviewhomework6.data.entity

data class Movie(var movie_id:Int,
                 var movie_type:MovieType?,
                 var movie_img:String,
                 var is_new: Boolean) {
}