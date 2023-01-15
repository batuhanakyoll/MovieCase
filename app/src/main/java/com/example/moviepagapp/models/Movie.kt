package com.example.moviepagapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity
data class Movie(
    @ColumnInfo("backdropPath")
    @SerializedName("backdrop_path") val backdropPath: String,
    @ColumnInfo("genreIDS")
    @SerializedName("genre_ids") val genreIDS: List<Long>,
    @ColumnInfo("originalLanguage")
    @SerializedName("original_language") val originalLanguage: String,
    @ColumnInfo("originalTitle")
    @SerializedName("original_title")  val originalTitle: String,
    @ColumnInfo("popularity")
    @SerializedName("popularity") val popularity: Double,
    @ColumnInfo("video")
    @SerializedName("video")  val video: Boolean,
    @ColumnInfo("voteAverage")
    @SerializedName("vote_average") val voteAverage: Double,
    @ColumnInfo("voteCount")
    @SerializedName("vote_count")  val voteCount: Long,
    @ColumnInfo("id")
    @SerializedName("id")  var id : Long,
    @ColumnInfo("title")
    @SerializedName("title") var title:String,
    @ColumnInfo("poster")
    @SerializedName("poster_path") var poster: String,
    @ColumnInfo("descirpiton")
    @SerializedName("overview") var descirpiton: String,
    @ColumnInfo("release")
    @SerializedName("release_date") var release : String) :Serializable {
        @PrimaryKey(autoGenerate = true)
        var uuid : Int = 0
}