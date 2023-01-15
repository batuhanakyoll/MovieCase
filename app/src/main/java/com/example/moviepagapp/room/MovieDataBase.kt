package com.example.moviepagapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviepagapp.models.Movie
import kotlinx.coroutines.CoroutineScope
/*
@Database(entities = arrayOf(Movie::class), version = 1)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun moviedao() : MovieDao


    //her yerden ulaşılmasına olanak tanır
    companion object{
         //Farklı threadlere görünür hale gelinir.
       @Volatile private  var instance : MovieDataBase? = null
        //instance var mı yok mu diye kontrol edilir yoksa üret
        private val lock = Any()

        operator fun invoke(context: CoroutineScope) = instance?: synchronized(lock){
            instance ?: makeDatabase().also {
                instance = it
            }
        }


        private fun makeDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,MovieDataBase::class.java,"moviedatabase").build()





    }
} */