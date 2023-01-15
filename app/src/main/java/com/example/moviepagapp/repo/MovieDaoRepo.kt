package com.example.moviepagapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviepagapp.api.ApiService
import com.example.moviepagapp.models.ApiResponse
import com.example.moviepagapp.models.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.math.log

class MovieDaoRepo(var mdao : ApiService) {
        val movieListLiveData : MutableLiveData<List<Movie>>

        init {
            movieListLiveData = MutableLiveData()
        }
    fun addallMovie(){
      mdao.getAllMovie().enqueue(object : retrofit2.Callback<ApiResponse>{
          override fun onFailure(call: Call<ApiResponse>, t: Throwable) {  }

          override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
            val liste = response.body()!!.result
              movieListLiveData.value = liste

              Log.e("Veriii",liste.toString())
          }
      })

      }
    fun getMovieL() : MutableLiveData<List<Movie>>{
        return movieListLiveData
    }


    fun movieSearch(searchWord: String){

    }
}