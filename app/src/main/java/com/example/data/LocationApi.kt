package com.example.data

import com.example.constants.Constants
import com.example.constants.Constants.MAP_API_KEY
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {
   @GET("geo/1.0/reverse")
    suspend fun getCityName(
       @Query("lat") lat: Double,
       @Query("lon") lon: Double,
       @Query("limit") limit: Int = 1,
       @Query("appid") appid: String = MAP_API_KEY) : Location

    companion object  {

        private const val BASE_URL = Constants.BASE_URL

        fun create() : LocationApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(LocationApiService::class.java)
        }
    }
}