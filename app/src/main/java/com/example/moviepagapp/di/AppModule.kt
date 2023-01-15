package com.example.moviepagapp.di

import com.example.moviepagapp.Utils.Constans
import com.example.moviepagapp.api.ApiService
import com.example.moviepagapp.repo.MovieDaoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl()=Constans.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String):ApiService =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMovieDaoRepo(mdao: ApiService) : MovieDaoRepo{
        return MovieDaoRepo(mdao)
    }



}