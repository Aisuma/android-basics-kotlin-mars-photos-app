package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

// When all else failed, ChatGPT found an unresolved naming conflict. This file was encased inside of a class with the name MarsApiService thanks to Android Studio.
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}

object MarsApi {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}