package com.example.moviepagapp.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class ApiResponse(@SerializedName("dates") val dates: DatesResponse,
                       @SerializedName("page")  val page: Int,
                       @SerializedName("results")  val result: List<Movie>,
                       @SerializedName("total_pages")  val total_pages: Int,
                       @SerializedName("total_results")  val total_results: Int) {
}