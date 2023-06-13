package com.example.data.category.response

import com.example.constants.Constants.DISHES_BASE_URL
import com.example.data.category.model.dishes.Dishes
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DishesApiService {
    @GET("aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): Dishes

    companion object {
        private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client : OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()


        fun create(): DishesApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(DISHES_BASE_URL)
                .client(client)
                .build()
            return retrofit.create(DishesApiService::class.java)
        }
    }
}