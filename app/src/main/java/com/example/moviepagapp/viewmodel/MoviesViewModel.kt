package com.example.moviepagapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.moviepagapp.api.ApiService
import com.example.moviepagapp.models.Movie
import com.example.moviepagapp.paging.MoviesPagingSource
import com.example.moviepagapp.repo.MovieDaoRepo
//import com.example.moviepagapp.room.MovieDataBase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel()
class MoviesViewModel @Inject constructor(private val apiService: ApiService , var mrepo : MovieDaoRepo):ViewModel() ,
    CoroutineScope {

    var movieListLiveData = MutableLiveData<List<Movie>>()

    init{
        loadMovie()
        movieListLiveData=mrepo.getMovieL()
    }
    val listData = Pager(PagingConfig(pageSize = 1)){
        MoviesPagingSource(apiService)

    }.flow.cachedIn(viewModelScope)


    fun search(searchWord: String){
    mrepo.movieSearch(searchWord)

    }
    fun loadMovie(){
        mrepo.addallMovie()

    }

   /* private fun stroeInSQLite(list:List<Movie>){
        launch {
            val dao = MovieDataBase(this).moviedao()
            dao.instertAll()
            val listLong = dao.instertAll(*list.toTypedArray())
            var i = 0
            while (i<list.size){
                list[i].title = listLong[i].toString()
                i = i+ 1
                loadMovie()
            }
        }
    } */

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main // işini yap main threade dön


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
    private fun showCountries(movieList: List<Movie>) {
        movieListLiveData.value = movieList


    }
}