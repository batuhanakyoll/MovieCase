package com.example.moviepagapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviepagapp.api.ApiService
import com.example.moviepagapp.models.Movie

class MoviesPagingSource(
    private val apiService: ApiService) : PagingSource<Int , Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {


            return try {
                val currentPage = params.key ?: 1
                val response = apiService.getAllMovies(currentPage)
                val data = response.body()?.result?: emptyList()
                val responseData = mutableListOf<Movie>()
                responseData.addAll(data)

                LoadResult.Page(
                    data = responseData,
                    prevKey = if (currentPage == 1) null else -1,
                    nextKey = currentPage.plus(1)

                )


            } catch (e: Exception) {
                LoadResult.Error(e)
            }

        }
}