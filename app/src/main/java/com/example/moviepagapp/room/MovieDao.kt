package com.example.moviepagapp.room

import android.icu.text.CaseMap.Title
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviepagapp.models.Movie
/*@Dao
interface MovieDao {
    @Insert
    suspend fun instertAll(vararg movie: Movie): List<Long>

    @Query("SELECT * FROM movie WHERE title :searchTitle")
    suspend fun searchTitle(searchTitle: String) : Movie


} */