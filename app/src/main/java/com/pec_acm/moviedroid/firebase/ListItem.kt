package com.pec_acm.moviedroid.firebase

import com.pec_acm.moviedroid.model.MovieResult
import com.pec_acm.moviedroid.model.TvResult

data class ListItem(
    val id : Int,
    val name : String,
    val category : String,
    val posterUrl : String,
    val score : Double,
    var personalScore : Int = 0,
    var status : Int = 0,
    var watchedEpisodes : Int = 0
){
    companion object{
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"

        fun MovieResult.toListItem() : ListItem
        {
            return ListItem(
                id,
                title,
                "movie",
                POSTER_URL+poster_path,
                vote_average
            )
        }

        fun MovieResult.toListItem(status: Int) : ListItem
        {
            val listItem = toListItem()
            listItem.status = status
            return listItem
        }

        fun TvResult.toListItem() : ListItem
        {
            return ListItem(
                id,
                name,
                "tv",
                POSTER_URL+poster_path,
                vote_average
            )
        }

        fun TvResult.toListItem(status: Int) : ListItem
        {
            val listItem = toListItem()
            listItem.status = status
            return listItem
        }
    }
}