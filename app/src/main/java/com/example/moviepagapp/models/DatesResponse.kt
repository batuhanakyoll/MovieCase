package com.example.moviepagapp.models

import com.google.gson.annotations.SerializedName

class DatesResponse(@SerializedName("maximum") val maximum: String,
                    @SerializedName("minimum") val minimum: String) {
}