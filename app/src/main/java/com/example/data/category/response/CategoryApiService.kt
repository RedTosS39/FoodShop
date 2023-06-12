package com.example.data.category.response

import com.example.constants.Constants.CATEGORY_BASE_URL
import com.example.data.category.model.CategoryList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CategoryApiService {

    @GET("058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategoryApi() : CategoryList

    companion object {

        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        fun create() : CategoryApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(CATEGORY_BASE_URL)
                .client(client)
                .build()
            return retrofit.create(CategoryApiService::class.java)
        }
    }
}